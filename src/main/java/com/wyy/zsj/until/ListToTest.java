/**
 * Author: hjw
 * Data: 2018/4/13 15:19
 * Description: String转成test
 */
package com.wyy.zsj.until;

import com.wyy.zsj.entity.Test;

import java.util.Iterator;
import java.util.List;

public class ListToTest {

    public Test listToTest(List list){
        Test test = new Test();
        int b=0;
        if(list.size()==19) {

            for (int i = 1; i < list.size() - 2; i++) {
                b++;
                if (b == 1) {
                    test.setTempv((String) list.get(i));
                }
                if (b == 2) {
                    test.setTemp1v((String) list.get(i));
                }
                if (b == 3) {
                    test.setTemp2v((String) list.get(i));
                }
                if (b == 4) {
                    test.setTemp3v((String) list.get(i));
                }
                if (b == 5) {
                    test.setTemp4v((String) list.get(i));
                }
                if (b == 6) {
                    test.setTemp5v((String) list.get(i));
                }
                if (b == 7) {
                    test.setTemp6v((String) list.get(i));
                }
                if (b == 8) {
                    test.setOutputv((String) list.get(i));
                }
                if (b == 9) {
                    test.setDefectivev((String) list.get(i));
                }
                if (b == 10) {
                    test.setThimblerulerv((String) list.get(i));
                }
                if (b == 11) {
                    test.setPlasticrulerv((String) list.get(i));
                }
                if (b == 12) {
                    test.setLockingrulerv((String) list.get(i));
                }
                if (b == 13) {
                    test.setFulltimev((String) list.get(i));
                }
                if (b == 14) {
                    test.setTimev((String) list.get(i));
                }
                if (b == 15) {
                    test.setSpeedv((String) list.get(i));
                }
                if (b == 16) {
                    test.setPressurev((String) list.get(i));
                }
            }
        }
        return test;
    }
}
