package com.wyy.zsj.mina;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.wyy.zsj.server.factory.ServerCodecFactory;
import com.wyy.zsj.server.handler.ServerMessageHandler;
import com.wyy.zsj.until.MyKeepAliveMessageFactory;
import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.keepalive.KeepAliveFilter;
import org.apache.mina.filter.keepalive.KeepAliveMessageFactory;
import org.apache.mina.filter.keepalive.KeepAliveRequestTimeoutHandler;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


/** 
* @author  hjw
* @date 创建时间：2018年4月8日 上午11:16:02
*/
@Component
public class MinaServer {
	private IoAcceptor acceptor;
    /** 监听端口 */
    private static final int PORT = 8081;
    /** 5秒进入空闲 */
    private static final int IDLETIMEOUT = 5;
    /** 2秒发送一次心跳包 */
    private static final int HEARTBEATRATE = 3;

    private static final Logger LOGGER = LoggerFactory.getLogger(MinaServer.class);


    @PostConstruct
    public void start() throws IOException {

        // 创建非阻塞的server端的Socket连接
        acceptor = new NioSocketAcceptor();
        DefaultIoFilterChainBuilder filterChain = acceptor.getFilterChain();

        // 设置session配置，空闲时间
        acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE,  IDLETIMEOUT);


        //添加编码过滤器 处理乱码、编码问题
        filterChain.addLast("codec", new ProtocolCodecFilter(new ServerCodecFactory()));

        //实现KeepAliveMessageFactory接口方法
//        KeepAliveMessageFactory heartBeatFactory = new MyKeepAliveMessageFactory();
//        KeepAliveRequestTimeoutHandlerImpl timeoutHandler = new KeepAliveRequestTimeoutHandlerImpl();
//        //创建拦截器，第一个参数是心跳处理接口，第二个参数是心跳超时处理接口
//        KeepAliveFilter heartBeat = new KeepAliveFilter(heartBeatFactory,IdleStatus.BOTH_IDLE, timeoutHandler);
//
//        //设置是否发送到下一个filter
//        heartBeat.setForwardEvent(true);
//        //设置心跳频率
//        heartBeat.setRequestInterval(HEARTBEATRATE);
//        //设置超时时间
//        heartBeat.setRequestTimeout(IDLETIMEOUT);
//
//        //添加心跳过滤器
//        acceptor.getFilterChain().addLast("heartbeat", heartBeat);

        // 设置核心消息业务处理器
        acceptor.setHandler(new ServerMessageHandler());

//        acceptor.getFilterChain().addLast("log", new LoggingFilter());

        // 绑定端口8081
        acceptor.bind(new InetSocketAddress(PORT));

        System.out.println("server -->"+PORT);


    }

    private static class KeepAliveRequestTimeoutHandlerImpl implements KeepAliveRequestTimeoutHandler{
        private static final Logger LOGGER = LoggerFactory.getLogger(MinaServer.class);
        @Override
        public void keepAliveRequestTimedOut(KeepAliveFilter keepAliveFilter, IoSession ioSession) throws Exception {
            ioSession.closeNow();
            LOGGER.info("心跳请求超时！");
        }
    }

    public static void main(String[] args) {
        MinaServer server = new MinaServer();
        try {
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
