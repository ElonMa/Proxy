package com.may.proxy;

public class HelloImpl implements  Hello{
    @Override
    public String sayHello() {
        System.out.println("hello world");
        return "hello";
    }
}
