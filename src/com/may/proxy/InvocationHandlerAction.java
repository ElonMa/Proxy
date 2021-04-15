package com.may.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Administrator
 */
public class InvocationHandlerAction implements InvocationHandler {

    Object target;
    public InvocationHandlerAction(Object target) {
        this.target=target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(proxy.getClass().getName());
        System.out.println("执行代理");
        return method.invoke(target,args);
    }
}
