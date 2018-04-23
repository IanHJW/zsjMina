package com.wyy.zsj.server.factory;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

import com.wyy.zsj.conversion.Convert;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.AttributeKey;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;
import org.apache.mina.filter.codec.textline.LineDelimiter;
import org.apache.mina.filter.codec.textline.TextLineEncoder;


/** 
* @author  黄军武（Ian）
* @date 创建时间：2018年4月8日 上午11:20:59
* @Function: ServerEncoder.java
* @version 1.0 
* @Description: 该类的功能描述
* @parameter  
* @return  
*/
public class ServerEncoder implements ProtocolEncoder {
    private static final AttributeKey ENCODER = new AttributeKey(TextLineEncoder.class, "encoder");
    private final Charset charset;
    private final LineDelimiter delimiter;
    private int maxLineLength;

    public ServerEncoder() {
        this(Charset.defaultCharset(), LineDelimiter.UNIX);
    }

    public ServerEncoder(String delimiter) {
        this(new LineDelimiter(delimiter));
    }

    public ServerEncoder(LineDelimiter delimiter) {
        this(Charset.defaultCharset(), delimiter);
    }

    public ServerEncoder(Charset charset) {
        this(charset, LineDelimiter.UNIX);
    }

    public ServerEncoder(Charset charset, String delimiter) {
        this(charset, new LineDelimiter(delimiter));
    }

    public ServerEncoder(Charset charset, LineDelimiter delimiter) {
        this.maxLineLength = 2147483647;
        if (charset == null) {
            throw new IllegalArgumentException("charset");
        } else if (delimiter == null) {
            throw new IllegalArgumentException("delimiter");
        } else if (LineDelimiter.AUTO.equals(delimiter)) {
            throw new IllegalArgumentException("AUTO delimiter is not allowed for encoder.");
        } else {
            this.charset = charset;
            this.delimiter = delimiter;
        }
    }
    public int getMaxLineLength() {
        return this.maxLineLength;
    }

    public void setMaxLineLength(int maxLineLength) {
        if (maxLineLength <= 0) {
            throw new IllegalArgumentException("maxLineLength: " + maxLineLength);
        } else {
            this.maxLineLength = maxLineLength;
        }
    }

    @Override
    public void encode(IoSession session, Object message, ProtocolEncoderOutput out) throws Exception {

        String str = message.toString();
        byte[] bytes = str.getBytes();
        IoBuffer buffer = IoBuffer.allocate(bytes.length).setAutoExpand(true);

        buffer.put(bytes);
        buffer.flip();

        //发送
        out.write(buffer);
        //刷新
        out.flush();

        buffer.free();;

    }

    public void dispose(IoSession session) throws Exception {

    }
}