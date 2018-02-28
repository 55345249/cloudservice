package com.cloud.core;

public class EchoServiceImpl implements EchoService {
    @Override
    public String echo(String ping) {
        return ping!=null ? ping + "--> I am Ok.":"ping is null.I am ok.";
    }
}
