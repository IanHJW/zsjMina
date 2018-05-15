/**
 * MyKeepAliveMessageFactory
 * @author: hjw
 * @data: 2018/5/5
 * Description: 心跳工厂
 */
package com.wyy.zsj.client.handler;


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
        return null;
    }
    @Override
    public Object getResponse(IoSession session, Object request) {
        // 返回给server端的数据
        return HEARTBEATRESPONSE;
    }
    @Override
    public boolean isRequest(IoSession session, Object message) {
        if (HEARTBEATREQUEST.equals(message)) {
            LOGGER.warn("心跳包吻合");
            return true;
        }
        return false;
    }
    @Override
    public boolean isResponse(IoSession session, Object message) {
        return false;
    }
}