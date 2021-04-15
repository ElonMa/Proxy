package com.may.proxy;

/**
 * @author Administrator
 */
public class ActionImpl   implements Action {

    @Override
    public void move() {
        System.out.println("target doing move");
    }
}
