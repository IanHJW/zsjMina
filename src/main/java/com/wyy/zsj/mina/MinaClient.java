package com.wyy.zsj.mina;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import com.wyy.zsj.client.factory.ClientCodecFactory;
import com.wyy.zsj.client.handler.ClientMessageHandler;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;


/** 
* @author  hjw
* date 创建时间：2018年4月8日 下午2:03:08
* Function: MinaClient.java
* version 1.0
* Description: 该类的功能描述
* parameter
* return
*/
public class MinaClient {
	private static  int port=8081;
    private static String host="localhost";
    private static IoSession session;
    private static IoConnector connector;
private static ConnectFuture future;

    public MinaClient(){
        connector = new NioSocketConnector();
    }

    public void start() {
        //添加字符的编码过滤器
        connector.getFilterChain().addLast("codec",
                new ProtocolCodecFilter(
                        new ClientCodecFactory(Charset.forName("utf-8"))));

        //设置核心消息业务处理器
        connector.setHandler(new ClientMessageHandler());

        //链接服务器
        future = connector.connect(new InetSocketAddress(host,port));

        //等待是否链接成功，相当于异步转同步执行
        future.awaitUninterruptibly();

        //获取session，通过session向服务器发送消息
        session = future.getSession();

        // 等待连接断开
        session.getCloseFuture().awaitUninterruptibly();

        //释放所有资源
        connector.dispose();

    }
    public static void main(String[] args) {
//        MinaClient client=new MinaClient();
//        try {
//            client.start();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
    }
}
