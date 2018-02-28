package com.cloud.bean;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectServiceImpl2 {

    private String name ;

    public ReflectServiceImpl2()
    {

    }

    public ReflectServiceImpl2(String name)
    {
        this.name = name;
    }

    public void sayHello()
    {
        System.out.println("Hello "+name);
    }

    public ReflectServiceImpl2 getInstance()
    {
        ReflectServiceImpl2 reflectServiceImpl2 = null;
        try {
        reflectServiceImpl2 = (ReflectServiceImpl2)Class.forName("com.cloud.bean.reflectServiceImpl2").getConstructor(String.class).newInstance("张三");
    } catch (InstantiationException e) {
        e.printStackTrace();
    } catch (IllegalAccessException e) {
        e.printStackTrace();
    } catch (InvocationTargetException e) {
        e.printStackTrace();
    } catch (NoSuchMethodException e) {
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
      return reflectServiceImpl2;
    }

    public void sayName(String name)
    {
        System.out.println("say "+name);
    }

    public static Object reflectMethod()
    {
        Object returnObj = null;
        ReflectServiceImpl2 rsi = new ReflectServiceImpl2("333");
        try {
            Method method = ReflectServiceImpl2.class.getMethod("sayHello");
            returnObj = method.invoke(rsi);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return  returnObj;

    }

    public static void main(String[] args) {


        System.out.println(reflectMethod());
    }
}
