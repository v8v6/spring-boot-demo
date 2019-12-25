package com.example.springbootdemo.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.example.springbootdemo.mapper.UserMapper;
import com.example.springbootdemo.model.User;
import com.example.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@DS("#header.platform")//从header获取
public class UserServiceImpl implements UserService {

  @Autowired
  UserMapper userMapper;

  @Override
  public int save(User user) {
    return userMapper.insert(user);
  }
}
