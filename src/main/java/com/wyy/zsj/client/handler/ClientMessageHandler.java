package com.wyy.zsj.client.handler;

import com.wyy.zsj.conversion.Imploded;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;


/** 
* @author  hjw
 *
 */
public class ClientMessageHandler extends IoHandlerAdapter {

    Imploded imploded = new Imploded();
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
        imploded.Date();
        System.out.println("服务器说："+str);



        //向server端发送数据
        session.write(imploded.transMit());
    }

    

	@Override
    public void messageSent(IoSession session, Object message) throws Exception {
        super.messageSent(session, message);
    }
}

