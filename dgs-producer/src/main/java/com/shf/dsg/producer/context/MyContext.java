package com.shf.dsg.producer.context;

/**
 * description :
 *
 * @author songhaifeng
 * @date 2022/5/8 2:32
 */
public class MyContext {
    private final String customState = "Custom state!";

    public String getCustomState() {
        return customState;
    }
}