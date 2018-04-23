package com.wyy.zsj.entity;
/**
 * Author: hjw
 * Data: 2018/4/13 13:58
 * Description: Test实体类
 */
public class Test {
    private Integer id;

    private String tempv;

    private String temp1v;

    private String temp2v;

    private String temp3v;

    private String temp4v;

    private String temp5v;

    private String temp6v;

    private String outputv;

    private String defectivev;

    private String thimblerulerv;

    private String plasticrulerv;

    private String lockingrulerv;

    private String fulltimev;

    private String timev;

    private String speedv;

    private String pressurev;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTempv() {
        return tempv;
    }

    public void setTempv(String tempv) {
        this.tempv = tempv == null ? null : tempv.trim();
    }

    public String getTemp1v() {
        return temp1v;
    }

    public void setTemp1v(String temp1v) {
        this.temp1v = temp1v == null ? null : temp1v.trim();
    }

    public String getTemp2v() {
        return temp2v;
    }

    public void setTemp2v(String temp2v) {
        this.temp2v = temp2v == null ? null : temp2v.trim();
    }

    public String getTemp3v() {
        return temp3v;
    }

    public void setTemp3v(String temp3v) {
        this.temp3v = temp3v == null ? null : temp3v.trim();
    }

    public String getTemp4v() {
        return temp4v;
    }

    public void setTemp4v(String temp4v) {
        this.temp4v = temp4v == null ? null : temp4v.trim();
    }

    public String getTemp5v() {
        return temp5v;
    }

    public void setTemp5v(String temp5v) {
        this.temp5v = temp5v == null ? null : temp5v.trim();
    }

    public String getTemp6v() {
        return temp6v;
    }

    public void setTemp6v(String temp6v) {
        this.temp6v = temp6v == null ? null : temp6v.trim();
    }

    public String getOutputv() {
        return outputv;
    }

    public void setOutputv(String outputv) {
        this.outputv = outputv == null ? null : outputv.trim();
    }

    public String getDefectivev() {
        return defectivev;
    }

    public void setDefectivev(String defectivev) {
        this.defectivev = defectivev == null ? null : defectivev.trim();
    }

    public String getThimblerulerv() {
        return thimblerulerv;
    }

    public void setThimblerulerv(String thimblerulerv) {
        this.thimblerulerv = thimblerulerv == null ? null : thimblerulerv.trim();
    }

    public String getPlasticrulerv() {
        return plasticrulerv;
    }

    public void setPlasticrulerv(String plasticrulerv) {
        this.plasticrulerv = plasticrulerv == null ? null : plasticrulerv.trim();
    }

    public String getLockingrulerv() {
        return lockingrulerv;
    }

    public void setLockingrulerv(String lockingrulerv) {
        this.lockingrulerv = lockingrulerv == null ? null : lockingrulerv.trim();
    }

    public String getFulltimev() {
        return fulltimev;
    }

    public void setFulltimev(String fulltimev) {
        this.fulltimev = fulltimev == null ? null : fulltimev.trim();
    }

    public String getTimev() {
        return timev;
    }

    public void setTimev(String timev) {
        this.timev = timev == null ? null : timev.trim();
    }

    public String getSpeedv() {
        return speedv;
    }

    public void setSpeedv(String speedv) {
        this.speedv = speedv == null ? null : speedv.trim();
    }

    public String getPressurev() {
        return pressurev;
    }

    public void setPressurev(String pressurev) {
        this.pressurev = pressurev == null ? null : pressurev.trim();
    }

    public Test() {
    }

    public Test(String tempv, String temp1v, String temp2v, String temp3v, String temp4v, String temp5v, String temp6v, String outputv, String defectivev, String thimblerulerv, String plasticrulerv, String lockingrulerv, String fulltimev, String timev, String speedv, String pressurev) {
        this.tempv = tempv;
        this.temp1v = temp1v;
        this.temp2v = temp2v;
        this.temp3v = temp3v;
        this.temp4v = temp4v;
        this.temp5v = temp5v;
        this.temp6v = temp6v;
        this.outputv = outputv;
        this.defectivev = defectivev;
        this.thimblerulerv = thimblerulerv;
        this.plasticrulerv = plasticrulerv;
        this.lockingrulerv = lockingrulerv;
        this.fulltimev = fulltimev;
        this.timev = timev;
        this.speedv = speedv;
        this.pressurev = pressurev;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", tempv='" + tempv + '\'' +
                ", temp1v='" + temp1v + '\'' +
                ", temp2v='" + temp2v + '\'' +
                ", temp3v='" + temp3v + '\'' +
                ", temp4v='" + temp4v + '\'' +
                ", temp5v='" + temp5v + '\'' +
                ", temp6v='" + temp6v + '\'' +
                ", outputv='" + outputv + '\'' +
                ", defectivev='" + defectivev + '\'' +
                ", thimblerulerv='" + thimblerulerv + '\'' +
                ", plasticrulerv='" + plasticrulerv + '\'' +
                ", lockingrulerv='" + lockingrulerv + '\'' +
                ", fulltimev='" + fulltimev + '\'' +
                ", timev='" + timev + '\'' +
                ", speedv='" + speedv + '\'' +
                ", pressurev='" + pressurev + '\'' +
                '}';
    }
}

