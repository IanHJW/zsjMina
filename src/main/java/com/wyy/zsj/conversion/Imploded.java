package com.wyy.zsj.conversion;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/** 
* @author  黄军武（Ian）
* @date 创建时间：2018年4月8日 上午11:25:58
* @Function: Imploded.java
* @version 1.0 
* @Description: 该类的功能描述
* @parameter  
* @return  
*/
public class Imploded {
	//写入数据
    public String transMit(){
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();
//        sc.close(); {关闭写入会出现迭代异常}
        return data;
    }

    //输出时间
    public Date Date() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd mm:hh:ss");
        System.out.println(sdf.format(date));
        return date;
    }
}
