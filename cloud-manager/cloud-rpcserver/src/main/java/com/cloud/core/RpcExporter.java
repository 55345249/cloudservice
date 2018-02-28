package com.cloud.core;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class RpcExporter {

    static Executor executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public static void exporter(String hostName,int port) throws Exception
    {
        ServerSocket server = new ServerSocket();
        server.bind(new InetSocketAddress(hostName,port));
        try {
            while (true)
            {
                System.out.println("服务启动中……");
                executor.execute(new ExporterTask(server.accept()));
                System.out.println("服务已启动，等待接收");
            }
        }
        finally {

        }
    }

}
