package com.wyy.zsj.entity;

public class Zsj {
    private Integer id;

    private String name;

    private Integer age;

    private String sex;

    private Double bodyweight;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Double getBodyweight() {
        return bodyweight;
    }

    public void setBodyweight(Double bodyweight) {
        this.bodyweight = bodyweight;
    }

    @Override
    public String toString() {
        return "Zsj{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", bodyweight=" + bodyweight +
                '}';
    }
}