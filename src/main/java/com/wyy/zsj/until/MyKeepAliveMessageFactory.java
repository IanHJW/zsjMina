/**
 * MyKeepAliveMessageFactory
 * @author: hjw
 * @data: 2018/5/5
 * Description: 心跳工厂
 */
package com.wyy.zsj.until;


import com.wyy.zsj.mina.MinaServer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.keepalive.KeepAliveMessageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ClassName MyKeepAliveMessageFactory
 * Description 实现KeepAliveMessageFactory（心跳工厂）
 * author cruise
 *
 */
public class MyKeepAliveMessageFactory implements KeepAliveMessageFactory {

    private static final Logger LOGGER= LoggerFactory.getLogger(MinaServer.class);
    /** 心跳包内容 */
    //预设请求内容
    private static final String HEARTBEATREQUEST = "hello";
    //预设应答内容
    private static final String HEARTBEATRESPONSE = "haha";

    @Override
    public Object getRequest(IoSession session) {
        LOGGER.warn("服务端发送给客户端的心跳包消息: " + HEARTBEATREQUEST);
        return HEARTBEATREQUEST;
    }
    @Override
    public Object getResponse(IoSession session, Object request) {
        return null;
    }
    @Override
    public boolean isRequest(IoSession session, Object message) {
        return false;
    }
    @Override
    public boolean isResponse(IoSession session, Object message) {
        if(HEARTBEATRESPONSE.equals(message)) {
            LOGGER.warn("客户端返回心跳包信息正确" );
            return true;
        }
        return false;
    }
}