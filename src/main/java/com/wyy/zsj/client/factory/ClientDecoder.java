package com.wyy.zsj.client.factory;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

import java.nio.charset.Charset;

/**
 *
 */
public class ClientDecoder extends CumulativeProtocolDecoder {
    private Charset charset;

    public ClientDecoder(Charset charset) {
        charset = this.charset;
    }
    @Override
    protected boolean doDecode(IoSession session, IoBuffer in, ProtocolDecoderOutput out) throws Exception {
        System.out.println("*---------client解码-----------*");

        //标记位置
        in.mark();

        byte[] bytes = new byte[in.remaining()];
        in.get(bytes,0,in.remaining());

        //转成string
        String string = new String(bytes);

        //发送数据
        out.write(string);

        //判断是否有粘包
        if(in.remaining()>0){
            in.reset();
            return true;
        }


        return false;
    }

}
