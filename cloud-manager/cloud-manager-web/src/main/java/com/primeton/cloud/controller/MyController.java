package com.primeton.cloud.controller;

import com.primeton.cloud.model.User;
import com.primeton.cloud.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping
@Api(tags="用户管理")
public class MyController {

    @Autowired
    private IUserService userService;

    @ApiOperation(httpMethod = "GET", value = "个人信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value="/showView",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> showView() {

        System.out.println("showView");

        Map<String,Object> map = new HashMap<String,Object>();

        List<User> users = new ArrayList<User>();

        User user = new User();
        user.setId(111);
        user.setName("22333");

        users.add(user);

        User user1 =  userService.getUserById(2);

        users.add(user1);

        map.put("result",users);

        return map;
    }

}
