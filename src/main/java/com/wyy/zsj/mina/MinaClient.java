package com.wyy.zsj.mina;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import com.wyy.zsj.client.factory.ClientCodecFactory;
import com.wyy.zsj.client.handler.ClientMessageHandler;
import com.wyy.zsj.client.handler.MyKeepAliveMessageFactory;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.keepalive.KeepAliveFilter;
import org.apache.mina.filter.keepalive.KeepAliveMessageFactory;
import org.apache.mina.transport.socket.nio.NioSocketConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


/** 
* @author  hjw
* date 创建时间：2018年4月8日 下午2:03:08
* Function: MinaClient.java
* version 1.0
* Description: 该类的功能描述
* parameter
* return
*/
@Component
public class MinaClient {
	private static  int port=8081;
    private static String host="localhost";
    private static IoSession session;
    private static IoConnector connector;
    private static ConnectFuture future;
    private static final Logger LOGGER= LoggerFactory.getLogger(MinaServer.class);


    @PostConstruct
    public void start() {
        connector = new NioSocketConnector();


        //第一个参数用于指定空闲状态，第二个参数用于指定Session的闲置时间（单位秒），
        // 此处含义为：读写 通道均在3 秒内无任何操作就进入空闲状态
//        connector.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 3);
        //添加字符的编码过滤器
        connector.getFilterChain().addLast("codec",
                new ProtocolCodecFilter(
                        new ClientCodecFactory(Charset.forName("utf-8"))));

        //设置核心消息业务处理器
        connector.setHandler(new ClientMessageHandler());

        //创建拦截器
//        KeepAliveMessageFactory heartBeatFactory = new MyKeepAliveMessageFactory();
//        //心跳过滤器
//        KeepAliveFilter heartBeat = new KeepAliveFilter(heartBeatFactory, IdleStatus.BOTH_IDLE);
//        heartBeat.setForwardEvent(true);
//        //添加心跳过滤器
//        connector.getFilterChain().addLast("heartBeat",heartBeat);

        //链接服务器
        future = connector.connect(new InetSocketAddress(host, port));

        // 阻塞直到和服务器连接成功
        future.awaitUninterruptibly();

    }
    public static void main(String[] args) {
        MinaClient minaClient = new MinaClient();
        minaClient.start();
    }
}
//设置连接超时
//        connector.setConnectTimeoutMillis(50000);
////
////        //      断线重连回调拦截器
////        connector.getFilterChain().addFirst("reconnection", new IoFilterAdapter() {
////            @Override
////            public void sessionClosed(NextFilter nextFilter, IoSession ioSession) throws Exception {
////                for(;;){
////                    try{
////                        Thread.sleep(3000);
////                        ConnectFuture future = connector.connect();
////                        // 等待连接创建成功
////                        future.awaitUninterruptibly();
////                        // 获取会话
////                        session = future.getSession();
////                        if(session.isConnected()){
////                            System.out.println("断线重连["+ connector.getDefaultRemoteAddress()+"]成功");
////                            break;
////                        }
////                    }catch(Exception ex){
////                        System.out.println("重连服务器登录失败,5秒再连接一次:" + ex.getMessage());
////                    }
////                }
////            }
////        });