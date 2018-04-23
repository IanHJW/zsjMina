package com.wyy.zsj.client.factory;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

import java.nio.charset.Charset;

/**
 * @author hjw
 */
public class ClientCodecFactory implements ProtocolCodecFactory {
    private final ClientDecoder decoder;
    private final ClientEncoder encoder;
    public ClientCodecFactory() {
        this(Charset.defaultCharset());
    }
    public ClientCodecFactory(Charset charset) {
        this.decoder = new ClientDecoder(charset);
        this.encoder = new ClientEncoder(charset);
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
