package com.shf.dsg.producer.entity;

/**
 * description :
 *
 * @author songhaifeng
 * @date 2022/5/4 12:42
 */
public class Actor {

    private String name;
    private int age;

    public Actor(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
