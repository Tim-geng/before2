package com.baidu.service.impl;

import com.baidu.dao.UserMapper;
import com.baidu.pojo.User;
import com.baidu.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;
    @Override
    public int add(User user) {
        return userMapper.insertSelective(user);
    }
}
