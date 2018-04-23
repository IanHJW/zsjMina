/**
 * Author: hjw
 * Data: 2018/4/13 17:43
 * Description: 对string charat 的取值实验
 */
package com.wyy.zsj.until;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringTest {
    public static void main(String[] args) {
        String string = "A1 01 021 03 04 05 06 07 08 09 10 11 12 13 14 15 16 B1";
        List<String> list = Arrays.asList(string.split(" "));


        System.out.println("list:" + list.get(2));
    }
}
