package com.wyy.zsj.server.factory;

import java.nio.charset.Charset;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

/** 
* @author  hjw
* @date 创建时间：2018年4月8日 上午11:23:35
* @Function: ServerCodecFactory.java
* @version 1.0 
* @Description: 该类的功能描述
* @parameter  
* @return  
*/
public class ServerCodecFactory implements ProtocolCodecFactory {
    private final ServerDecoder decoder;
    private final ServerEncoder encoder;
    public ServerCodecFactory() {
        this(Charset.defaultCharset());
    }
    public ServerCodecFactory(Charset charset) {
        this.decoder = new ServerDecoder(charset);
        this.encoder = new ServerEncoder();
    }
    @Override
    public ProtocolEncoder getEncoder(IoSession session) throws Exception {
        return encoder;
    }
    @Override
    public ProtocolDecoder getDecoder(IoSession session) throws Exception {
        return decoder;
    }
}

