package com.wyy.zsj.mina;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import com.wyy.zsj.server.factory.ServerCodecFactory;
import com.wyy.zsj.server.handler.ServerMessageHandler;
import com.wyy.zsj.service.TestService;
import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.LineDelimiter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.SocketAcceptor;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;


/** 
* @author  黄军武（Ian）
* @date 创建时间：2018年4月8日 上午11:16:02
* @Function: MinaServer.java
* @version 1.0 
* @Description: 该类的功能描述
* @parameter  
* @return  
*/
public class MinaServer {
	private SocketAcceptor acceptor;
    /** 监听端口 */
    private static final int PORT = 8081;
    /** 空闲时间，单位：秒 */
    private static final int IDLE_TIME = 60;

    public MinaServer() {
        // 创建非阻塞的server端的Socket连接
        acceptor = new NioSocketAcceptor();
    }

    public void start() throws IOException {
        DefaultIoFilterChainBuilder filterChain = acceptor.getFilterChain();
//        LoggingFilter loggingFilter = new LoggingFilter();
//        //生成日志
//        filterChain.addLast("logging", loggingFilter);

        // 添加编码过滤器 处理乱码、编码问题
        filterChain.addLast("codec", new ProtocolCodecFilter(new ServerCodecFactory()));

//        filterChain.addLast("codec",
//                new ProtocolCodecFilter(
//                        new TextLineCodecFactory(Charset.forName("UTF-8"),
//                        LineDelimiter.WINDOWS.getValue(),
//                                LineDelimiter.WINDOWS.getValue())));

         // 设置核心消息业务处理器
        acceptor.setHandler(new ServerMessageHandler());

         // 设置session配置，空闲状态时间
        acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, IDLE_TIME);

         // 绑定端口8081
        acceptor.bind(new InetSocketAddress(PORT));

        System.out.println("server -->"+PORT);
}

    public static void main(String[] args) {
//        MinaServer server = new MinaServer();
//        try {
//            server.start();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
