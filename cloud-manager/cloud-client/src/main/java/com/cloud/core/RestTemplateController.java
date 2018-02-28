package com.cloud.core;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestTemplateController {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "findByIdFallback")
    @GetMapping("/template/{id}")
    public String findById(@PathVariable Long id) {// 将原来的ip:port的形式，改成注册到Eureka Server上的应用名即可
       System.out.println("findById");
       String u = this.restTemplate.getForObject("http://127.0.0.1:8764/service1/service" , String.class);

    //    String u = this.restTemplate.getForObject("http://SERVICE1/service" , String.class);

        System.out.println(u);
        return "请求值："+id+"。返回值："+u;
    }

    public String findByIdFallback(Long id, Throwable e)
    {
        System.out.println("错误"+e);
        return "Hystrix已经被触发，执行方法：findByIdFallback";
    }
}
