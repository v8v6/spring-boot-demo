package com.example.springboot.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springboot.demo.mapper.UserMapper;
import com.example.springboot.demo.model.User;
import com.example.springboot.demo.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Author chenjunxi02
 * @Date 2021/1/4
 */

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
