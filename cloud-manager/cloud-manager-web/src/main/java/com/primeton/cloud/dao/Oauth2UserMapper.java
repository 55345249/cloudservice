package com.primeton.cloud.dao;

import com.primeton.cloud.model.Oauth2User;

public interface Oauth2UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Oauth2User record);

    int insertSelective(Oauth2User record);

    Oauth2User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Oauth2User record);

    int updateByPrimaryKey(Oauth2User record);
}