package com.example.springbootdemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbootdemo.mapper.UserMapper;
import com.example.springbootdemo.model.User;
import com.example.springbootdemo.service.UserDBService;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDBServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserDBService {

    @Override
    public List<User> testListByLogicDelete() {
        return baseMapper.testListByLogicDelete();
    }
}
