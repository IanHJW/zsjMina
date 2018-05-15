package com.wyy.zsj.server.handler;

import com.wyy.zsj.conversion.Imploded;
import com.wyy.zsj.entity.Test;
import com.wyy.zsj.service.TestService;
import com.wyy.zsj.until.ListToTest;
import com.wyy.zsj.until.SpringContextUtil;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import java.net.InetSocketAddress;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/** 
* @author  hjw
* date 创建时间：2018年4月8日 上午11:26:56
* Function: ServerMessageHandler.java
* version 1.0
* Description: 该类的功能描述
* parameter
* return
*/
public class ServerMessageHandler extends IoHandlerAdapter {

    /**
     * 调用SpringContextUtil 获取 applicationContext
     */
//    ApplicationContext applicationContext = SpringContextUtil.getApplicationContext();
//    TestService testService = applicationContext.getBean(TestService.class);

    private static final Logger LOGGER = LoggerFactory.getLogger(ServerMessageHandler.class);
    int num = 0;

    public static ConcurrentHashMap<Long, IoSession> sessionsConcurrentHashMap = new ConcurrentHashMap<Long, IoSession>();

    Imploded i = new Imploded();
    @Override
    public void sessionCreated(IoSession session) throws Exception {
        //session 创建。
        LOGGER  .warn("remote client [" + session.getRemoteAddress().toString() + "] connected.");

        // my
        Long time = System.currentTimeMillis();
        session.setAttribute("id", time);
        sessionsConcurrentHashMap.put(time, session);

    }
    @Override
    public void sessionOpened(IoSession session) throws Exception {
        //连接打开。
        LOGGER.info("打开一个session id："+ session.getId()+
                "  空暇连接个数IdleCount：  "+ session.getBothIdleCount());
    }
    @Override
    public void sessionClosed(IoSession session) throws Exception {
        //连接关闭。
        LOGGER.warn("sessionClosed");
        // my
        sessionsConcurrentHashMap.remove(session.getAttribute("id"));
    }
    @Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
        LOGGER.warn("idle");
        session.write("hello");

        num++;
        if(num==5){
            session.closeNow();
            LOGGER.info("session close");
        }
    }
    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        //异常，如果是 IOException 异常将自动关闭 MINA 连接。
        LOGGER.warn("session occured exception, so close it." + cause.getMessage());
        LOGGER.warn(cause.toString());
    }
    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {

        byte[] bytes = (byte[])message;
        String str = new String(bytes);
        i.Date();
        if("haha".equals(str)){
            LOGGER.info("心跳正常");
            num=0;
        }else {
            LOGGER.info(str);
        }
        //string转成list数组
        List<String> list = new ArrayList<String>();
        list=(Arrays.asList(str.split("-")));
//        System.out.println("list数据："+list);


        ListToTest toTest = new ListToTest();
        Test test = toTest.listToTest(list);

//        System.out.println("插入数据：" + testService.insert(test));
//        LOGGER.warn("客户端" + ((InetSocketAddress) session.getRemoteAddress()).getAddress().getHostAddress() + "连接成功！");
//        session.setAttribute("type", message);
//        String remoteAddress = ((InetSocketAddress) session.getRemoteAddress()).getAddress().getHostAddress();
//        session.setAttribute("ip", remoteAddress);


        //向客户端发送信息
        session.write(i.transMit());

        super.messageReceived(session,message);

    }
    @Override
    public void messageSent(IoSession session, Object message) throws Exception {
        //发送消息后调用。
        super.messageSent(session, message);
        LOGGER.warn("Server 发送消息：" + message);
    }
    @Override
    public void inputClosed(IoSession ioSession)  {
//        num++;
//        if(num==5){
//            ioSession.closeNow();
//            LOGGER.info("session close");
//        }
        ioSession.closeNow();
        LOGGER.info("关闭session");
    }
}
