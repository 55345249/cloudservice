package com.primeton.cloud.dao;

import com.primeton.cloud.model.Oauth2Client;

public interface Oauth2ClientMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Oauth2Client record);

    int insertSelective(Oauth2Client record);

    Oauth2Client selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Oauth2Client record);

    int updateByPrimaryKey(Oauth2Client record);
}