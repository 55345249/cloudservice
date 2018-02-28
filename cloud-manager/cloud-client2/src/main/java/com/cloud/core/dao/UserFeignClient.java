package com.cloud.core.dao;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="feignClient")
@RequestMapping(value = "/{id}",method = RequestMethod.GET)
public interface UserFeignClient {

    public String findById(@PathVariable("id") Long id);

}
