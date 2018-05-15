/**
 * @Author: hjw
 * Data: 2018/4/13 16:00
 * Description: 项目启动类
 */
package com.wyy.zsj;

import com.wyy.zsj.until.SpringContextUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;

/**
 *  @EnableAdminServer 心跳反应的启用
 */
@SpringBootApplication
@ComponentScan("")
public class ZsjMina {

    /**
     * 注入SpringContextUtil ，使普通类可以调用spring service 和dao
     * @return rep
     */
    @Bean
    public SpringContextUtil getSpringContextUtil(){
        return new SpringContextUtil();
    }

    public static void main(String[] args) {
        SpringApplication.run(ZsjMina.class,args);

//        MinaServer minaServer = new MinaServer();
//        MinaClient minaClient = new MinaClient();
//        try {
//            minaServer.start();
//            minaClient.start();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
