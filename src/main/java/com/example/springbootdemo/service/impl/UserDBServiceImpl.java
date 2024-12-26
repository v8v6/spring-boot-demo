package com.example.springbootdemo.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
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

    @SentinelResource(value = "test1")
    @Override
    public void test1() {
        // 随机睡眠 1-5 秒
        long sleep = (long) (Math.random() * 4000 + 1000);
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
