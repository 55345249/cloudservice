package com.cloud.core;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;

public class RpcClientTest {

    public static void main(String[] args) {
        try {
            //接口名称
            String interfaceName = EchoService.class.getName();
            //接口方法
            Method method = EchoService.class.getMethod("echo", java.lang.String.class);
            //参数
            Object[] arguments = {"hello111"};
            System.out.println("11111111");
            Socket socket = new Socket("localhost",9999);

            //发送请求
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeUTF(interfaceName);
            out.writeUTF(method.getName());
            out.writeObject(method.getParameterTypes());
            out.writeObject(arguments);

            System.out.println("222222");
            //获取结果
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            Object returnObject = inputStream.readObject();
            System.out.println("33333");
            System.out.println(returnObject.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
