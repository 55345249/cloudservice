package com.cloud.core;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.Arrays;

public class ExporterTask implements Runnable{

    Socket client = null;

    public ExporterTask(Socket client)
    {
        System.out.println("初始化client。");
        this.client = client;
        System.out.println("初始化client……"+client);
    }


    @Override
    public void run() {

        ObjectInputStream input = null;
        ObjectOutputStream output = null;

        try {
            System.out.println("等待接收……");
            input = new ObjectInputStream(client.getInputStream());

            String interfaceName = input.readUTF();   //接口名称

            System.out.println("interfaceName："+ interfaceName);

            Class<?> service = Class.forName(interfaceName);

            Class<?> serviceImpl = Class.forName(interfaceName+"Impl");

            String methodName = input.readUTF(); //方法名称

            System.out.println("methodName："+ methodName);

            Class<?>[] parameterTypes = (Class<?>[])input.readObject();  //方法类型

            System.out.println("parameterTypes："+ parameterTypes);

            Object[] arguments = (Object[]) input.readObject();

            System.out.println("接收到的参数："+ Arrays.toString(arguments));

            Method method = service.getMethod(methodName,parameterTypes);

       //     EchoService serviceImpl = new EchoServiceImpl();

        //    Object result = method.invoke(service.newInstance(),arguments);

            Object result = method.invoke(serviceImpl.newInstance(),arguments);

            output = new ObjectOutputStream(client.getOutputStream());
            output.writeObject(result);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            if(output!=null)
            {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(input!=null)
            {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(client!=null)
            {
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }


    }
}
