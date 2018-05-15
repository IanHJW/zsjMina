package com.wyy.zsj.client.handler;

import com.wyy.zsj.conversion.Imploded;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
* @author  hjw
 *
 */
public class ClientMessageHandler extends IoHandlerAdapter {

    //预设请求内容
    private static final String HEARTBEATREQUEST = "ss";
    //预设应答内容
    private static final String HEARTBEATRESPONSE = "haha";

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientMessageHandler.class);
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
        LOGGER.warn("ClientMessageHandler sessionClosed");

    }

    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        System.out.println("客户端发生异常"+cause);
    }

	@Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        String str = message.toString();
        imploded.Date();
        LOGGER.warn("服务器说："+str);
        if("hello".equals(message)){
            LOGGER.warn("客户端收到心跳包");
            session.write(HEARTBEATRESPONSE);
        }else {
            session.write(imploded.transMit());
        }

        //向server端发送数据
//        session.write(imploded.transMit());
    }

    

	@Override
    public void messageSent(IoSession session, Object message) throws Exception {
        super.messageSent(session, message);
    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
        System.out.println("-客户端与服务端连接[空闲] - " + status.toString());
    }
}

