package com.wyy.zsj.server.handler;

import com.wyy.zsj.conversion.Convert;
import com.wyy.zsj.conversion.Imploded;
import com.wyy.zsj.entity.Test;
import com.wyy.zsj.service.TestService;
import com.wyy.zsj.service.impl.TestServiceImpl;
import com.wyy.zsj.until.ListToTest;
import com.wyy.zsj.until.SpringContextUtil;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 
* author  hjw
* date 创建时间：2018年4月8日 上午11:26:56
* Function: ServerMessageHandler.java
* version 1.0
* Description: 该类的功能描述
* parameter
* return
*/
public class ServerMessageHandler extends IoHandlerAdapter {
//    private final static Logger LOGGER = LoggerFactory.getLogger(ServerMessageHandler.class);

    /**
     * 调用SpringContextUtil 获取 applicationContext
     */
    ApplicationContext applicationContext = SpringContextUtil.getApplicationContext();
    TestService testService = applicationContext.getBean(TestService.class);


    Imploded i = new Imploded();
    @Override
    public void sessionCreated(IoSession session) throws Exception {
        //session 创建。
        System.out.println("创建一个新连接："+ session.getRemoteAddress()+"id:"+session.getId());

        session.write("Welcome your arrival");
    }
    @Override
    public void sessionOpened(IoSession session) throws Exception {
        //连接打开。
        System.out.println("打开一个session id："+ session.getId()+
                "  空暇连接个数IdleCount：  "+ session.getBothIdleCount());
    }
    @Override
    public void sessionClosed(IoSession session) throws Exception {
        //连接关闭。
        System.out.println("sessionClosed");
    }
    @Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {

    }
    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        //异常，如果是 IOException 异常将自动关闭 MINA 连接。
        System.out.println("exceptionCaught：" + cause.getMessage());
    }
    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
//        String str = Convert.bytesToHexString(bytes);

        byte[] bytes = (byte[])message;
        String str = new String(bytes);
        i.Date();

        //string转成list数组
        List<String> list = new ArrayList<String>();
        list=(Arrays.asList(str.split("-")));
        System.out.println("list数据："+list);


        ListToTest toTest = new ListToTest();
        Test test = toTest.listToTest(list);

        System.out.println("插入数据：" + testService.insert(test));

//        LOGGER.info("This is message received id [" + str + "]");
        //向客户端发送信息
        session.write(i.transMit());

        super.messageReceived(session,message);

    }
    @Override
    public void messageSent(IoSession session, Object message) throws Exception {
        //发送消息后调用。
        super.messageSent(session, message);
        System.out.println("Server 发送消息：" + message);
    }
    @Override
    public void inputClosed(IoSession ioSession) throws Exception {

    }
}
