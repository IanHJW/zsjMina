package com.wyy.zsj.conversion;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author hjw
 */
public class Imploded {
    /**
     * 写入数据
     */
    public String transMit(){
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();
        /**
         *   sc.close(); {关闭写入会出现迭代异常}
         */
        return data;
    }

    /**
     * Date
     * 输出时间
     */
    public Date Date() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd mm:hh:ss");
        System.out.println(sdf.format(date));
        return date;
    }
}
