package com.example.springbootdemo.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.example.springbootdemo.mapper.UserMapper;
import com.example.springbootdemo.model.DataArea;
import com.example.springbootdemo.model.User;
import com.example.springbootdemo.service.DataAreaService;
import com.example.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
//从header获取
public class UserServiceImpl implements UserService {

  @Autowired
  UserMapper userMapper;

  @Autowired
  DataAreaService dataAreaService;

  @Override
  public int save(User user) {
    DataArea dataArea = dataAreaService.selectOne(1L);

    user.setEmail(dataArea.getName());

    saveUser(user);
    return 9;
  }

  @DS("#header.platform")
  @Transactional(rollbackFor = Exception.class)
  public void saveUser(User user) {
    userMapper.insert(user);
    int i = 1/0;
  }


}
