package com.example.springbootdemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springbootdemo.model.User;

import java.util.List;

public interface UserDBService extends IService<User> {

    List<User> testListByLogicDelete();

}
