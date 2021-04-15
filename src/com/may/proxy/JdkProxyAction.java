package com.may.proxy;

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

public class JdkProxyAction {


        public static void main(String[] args) throws Exception {
            Action targetAction = new ActionImpl();
            Action proxy = (Action) Proxy.newProxyInstance(targetAction.getClass().getClassLoader(), targetAction.getClass().getInterfaces(), new InvocationHandlerAction(targetAction));
            proxy.move();

            System.out.println("-------------");

            Hello hello = new HelloImpl();
            Hello hello1 = (Hello) Proxy.newProxyInstance(hello.getClass().getClassLoader(), hello.getClass().getInterfaces(), new InvocationHandlerAction(hello));
            String result = hello1.sayHello();
            System.out.println(result);

        }




}
