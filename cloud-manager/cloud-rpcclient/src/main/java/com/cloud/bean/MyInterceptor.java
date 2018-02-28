package com.cloud.bean;

import java.lang.reflect.Method;

public class MyInterceptor implements Interceptor {
    @Override
    public boolean before(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("反射前");
        return true;
    }

    @Override
    public void around(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("取代被代理对象方法");
    }

    @Override
    public void after(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("反射后");
    }
}
