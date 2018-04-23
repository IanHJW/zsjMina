package com.wyy.zsj.client.handler;

import com.wyy.zsj.conversion.Imploded;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;


/** 
* @author  黄军武（Ian）
* @date 创建时间：2018年4月8日 上午11:27:52
* @Function: ClientMessageHandler.java
* @version 1.0 
* @Description: 该类的功能描述
* @parameter  
* @return  
*/
public class ClientMessageHandler extends IoHandlerAdapter {


    Imploded i = new Imploded();
    @Override
    public void sessionCreated(IoSession session) throws Exception {
        super.sessionCreated(session);
    }

    @Override
    public void sessionOpened(IoSession session) throws Exception {
        super.sessionOpened(session);
    }

    @Override
    public void sessionClosed(IoSession session) throws Exception {
        super.sessionClosed(session);
        System.out.println("ClientMessageHandler sessionClosed");
    }

    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        System.out.println("客户端发生异常"+cause);
    }

	@Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        String str = message.toString();
        i.Date();
        System.out.println("服务器说："+str);



        //向server端发送数据
        session.write(i.transMit());
    }

    

	@Override
    public void messageSent(IoSession session, Object message) throws Exception {
        super.messageSent(session, message);
    }
}

