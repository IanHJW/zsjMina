package com.wyy.zsj.server.factory;

import java.nio.charset.Charset;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

/** 
* @author  hjw
* @date 创建时间：2018年4月8日 上午11:22:56
*/
public class ServerDecoder extends CumulativeProtocolDecoder {
    private Charset charset;

    public ServerDecoder(Charset charset) {
        charset = this.charset;
    }

    @Override
    protected boolean doDecode(IoSession session, IoBuffer in, ProtocolDecoderOutput out)  {
        System.out.println("*------------server解码-------------*");

        byte[] bytes = new byte[in.remaining()];
        in.get(bytes,0,in.remaining());

        //发送数据
        out.write(bytes);

        /* 判断是否有粘包 */
        if(in.remaining()>0){
            in.reset();
            return true;
        }


        return false;
    }

}