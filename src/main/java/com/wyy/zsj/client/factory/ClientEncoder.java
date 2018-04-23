package com.wyy.zsj.client.factory;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;

import java.nio.charset.Charset;

/**
 * @author hjw
 * @date 2018/4/23
 */
public class ClientEncoder implements ProtocolEncoder {
    private final Charset charset;

    public ClientEncoder(Charset charset) {
        this.charset = charset;
    }

    @Override
    public void encode(IoSession session, Object message, ProtocolEncoderOutput out)  {
        System.out.println("*----------------client编码-----------------*");
        String str = message.toString();
        //转成16进制
//        byte[] bytes = Convert.hexStringToByte(str);

        if(str.length()==0){
            System.out.println("发送的值为空！");
        }
        byte[] bytes = str.getBytes();

        //根据message长度开创空间
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
    public void dispose(IoSession ioSession)  {

    }
}
