package com.cloud.core;

public class RpcTest {
    public static void main(String[] args) throws Exception{
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("RpcTest begin");
                    RpcExporter.exporter("localhost",9999);
                    System.out.println("RpcTest end");
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }).start();


    }
}
