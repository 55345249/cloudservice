package com.cloud.bean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class InterceptorJdkProxy implements InvocationHandler {

    private Object target; //真实对象

    private String interceptorClass = null; //拦截器权限定名

    public InterceptorJdkProxy(Object target,String interceptorClass)
    {
        this.target = target;
        this.interceptorClass = interceptorClass;
    }



    public static Object bind(Object target,String interceptorClass)
    {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),new InterceptorJdkProxy(target,interceptorClass));
    }



    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(interceptorClass ==null)
        {
            return method.invoke(target,args);
        }

        Object result = null;

        Interceptor interceptor = (Interceptor) Class.forName(interceptorClass).newInstance();

        if(interceptor.before(proxy,target,method,args))
        {
            result = method.invoke(target,args);
            System.out.println("----------1-----------");
        }
        else {
            interceptor.around(proxy,target,method,args);
            System.out.println("----------2-----------");
        }

        interceptor.after(proxy,target,method,args);
        System.out.println("----------3-----------");

        return result;
    }
}
