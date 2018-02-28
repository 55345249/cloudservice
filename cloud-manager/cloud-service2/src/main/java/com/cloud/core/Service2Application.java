package com.cloud.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class Service2Application {

/*    @RequestMapping("/service2")
    public String service2(){
        return "service2";
    }*/

    @GetMapping("/service")
    public String service(){
        System.out.println("service");
        return "service";
    }

    public static void main(String[] args) {
        SpringApplication.run(Service2Application.class, args);
    }
}
