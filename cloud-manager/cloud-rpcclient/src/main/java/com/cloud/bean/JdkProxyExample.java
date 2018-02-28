package com.cloud.bean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyExample implements InvocationHandler{

    private Object target = null;

    public Object bind(Object target)
    {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("进入代理逻辑方法");
        System.out.println("在调度真实对象之前的服务");

        Object obj = method.invoke(target,args);
        System.out.println("在调度真实对象之后的服务");

        return obj;
    }

    public static void testJdkProxy()
    {
        JdkProxyExample jdkProxyExample = new JdkProxyExample();
        HelloWorld hw =  (HelloWorld)jdkProxyExample.bind(new HelloWorldImpl());
        hw.sayHelloWorld();

    }

    public static void main(String[] args) {

     //   testJdkProxy();



/*        CglibProxyExample cglibProxyExample = new CglibProxyExample();
        ReflectServiceImpl obj =(ReflectServiceImpl) cglibProxyExample.bind(ReflectServiceImpl.class);
        obj.sayByeBye("ahaha");
        obj.sayHello("3333");*/

        HelloWorld  proxy = (HelloWorld) InterceptorJdkProxy.bind(new HelloWorldImpl(),"com.cloud.bean.MyInterceptor");


        proxy.sayHelloWorld();

    }

}
