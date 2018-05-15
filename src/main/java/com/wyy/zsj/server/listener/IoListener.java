/**
 * @author: hjw
 * Data: 2018/4/28 9:15
 * Description: 对客户端是否断线的监听
 */
package com.wyy.zsj.server.listener;

import org.apache.mina.core.service.IoService;
import org.apache.mina.core.service.IoServiceListener;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

public class IoListener implements IoServiceListener{

    @Override
    public void serviceActivated(IoService ioService) throws Exception {

    }

    @Override
    public void serviceIdle(IoService ioService, IdleStatus idleStatus) throws Exception {

    }

    @Override
    public void serviceDeactivated(IoService ioService) throws Exception {

    }

    @Override
    public void sessionCreated(IoSession ioSession) throws Exception {

    }

    @Override
    public void sessionClosed(IoSession ioSession) throws Exception {

    }

    @Override
    public void sessionDestroyed(IoSession ioSession) throws Exception {

    }
}
