package com.shf.common.entity;

/**
 * description :
 *
 * @author songhaifeng
 * @date 2022/5/8 17:45
 */
public class Director {
    private String id;
    private String name;

    public Director() {
    }

    public Director(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
