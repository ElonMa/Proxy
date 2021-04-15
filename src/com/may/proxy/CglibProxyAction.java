package com.may.proxy;

import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;

/**
 * dk动态代理的被代理类必须实现接口
 * JDK动态代理的组成
 * 1.被代理类的接口 A
 * 2.被代理类 B
 * 3.实现了InvocationHandler接口的处理逻辑类 C(此类可复用)
 * 4.Proxy.newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h) throws IllegalArgumentException方法生成的代理类，此代理类实现了被代理类的接口A和接口Proxy.
 *
 */

public class CglibProxyAction {


        public static void main(String[] args) throws Exception {



            ActionImpl targetAction = new ActionImpl();
            CglibCallBackInvocationHandler handler = new CglibCallBackInvocationHandler(targetAction);
            Enhancer enhancer = new Enhancer();
            //设置代理什么类
            enhancer.setSuperclass(targetAction.getClass());
            //设置invoker
            enhancer.setCallback(handler);
            ActionImpl result = (ActionImpl) enhancer.create();
            result.move();

            System.out.println("-------------");

            HelloImpl hello = new HelloImpl();
            CglibCallBackInvocationHandler handler2 = new CglibCallBackInvocationHandler(hello);
            Enhancer enhancer2 = new Enhancer();
            //设置代理什么类
            enhancer2.setSuperclass(hello.getClass());
            //设置invoker
            enhancer2.setCallback(handler2);
            HelloImpl result2 = (HelloImpl) enhancer2.create();
            result2.sayHello();

        }




}
