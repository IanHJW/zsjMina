package com.wyy.zsj.server.factory;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;


/** 
* @author  hjw
* @date 创建时间：2018年4月8日 上午11:20:59
*/
public class ServerEncoder implements ProtocolEncoder {

    @Override
    public void encode(IoSession session, Object message, ProtocolEncoderOutput out)  {

        String str = message.toString();
        byte[] bytes = str.getBytes();
        IoBuffer buffer = IoBuffer.allocate(bytes.length).setAutoExpand(true);

        buffer.put(bytes);
        buffer.flip();

        //发送
        out.write(buffer);
        //刷新
        out.flush();

        buffer.free();

    }

    @Override
    public void dispose(IoSession session)  {

    }
}