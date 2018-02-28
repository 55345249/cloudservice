package com.cloud.bean;

public class ReflectServiceImpl {

    public void sayHello(String name)
    {
        System.out.println("Hello "+name);
    }


    public void sayByeBye(String name)
    {
        System.out.println("Bye Bye "+name);
    }

    public ReflectServiceImpl getInstance()
    {
        ReflectServiceImpl reflectService = null;
        try {
            reflectService =(ReflectServiceImpl) Class.forName("com.cloud.bean.ReflectServiceImpl").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return  reflectService;
    }

}

