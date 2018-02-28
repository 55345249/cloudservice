package com.primeton.cloud.service;

import com.primeton.cloud.dao.UserMapper;
import com.primeton.cloud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IUserServiceImpl implements IUserService{

    @Autowired
    private UserMapper userMapper;
    @Override
    public User getUserById(int id) {
        System.out.println("getUserById:"+id);
        return userMapper.selectByPrimaryKey(id);
    }

}
