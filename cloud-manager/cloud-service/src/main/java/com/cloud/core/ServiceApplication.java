package com.cloud.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ServiceApplication {

    @GetMapping("/service")
    @ResponseBody
    public Map<String, String> service(){
        System.out.println("service");
        Map<String,String > map =new HashMap<String, String>();
        map.put("key1","value1");
        map.put("key2","value2");
        return map;
    }

    public static void main(String[] args) {
        SpringApplication.run(ServiceApplication.class, args);
    }
}

