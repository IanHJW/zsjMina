/**
 * @author: hjw
 * Data: 2018/5/10 15:59
 * Description: 定时器
 */
package com.wyy.zsj.until;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimeTest {
//    public static void main(String[] args) {
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                // task to run goes here
//                System.out.println("Hello !!");
//            }
//        };
//        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
//        // 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间
//        service.scheduleAtFixedRate(runnable, 0, 15, TimeUnit.SECONDS);
//    }
    public static void main(String[] args) {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                // task to run goes here
                System.out.println("Hello !!!");
            }
        };
        Timer timer = new Timer();
        long delay = 0;
        long intevalPeriod = 1 * 1000;
        // schedules the task to be run in an interval
        timer.scheduleAtFixedRate(task, delay, intevalPeriod);
    }

}
