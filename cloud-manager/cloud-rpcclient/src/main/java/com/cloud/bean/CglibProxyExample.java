package com.cloud.bean;

import com.sun.jdi.Method;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxyExample implements MethodInterceptor {


    public Object bind(Class cls)
    {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(cls);
        enhancer.setCallback(this);
        return enhancer.create();
    }


    @Override
    public Object intercept(Object o, java.lang.reflect.Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("调用真实对象前");

        Object result = methodProxy.invokeSuper(o,objects);

        System.out.println("调用真实对象后");

        return result;
    }
}
