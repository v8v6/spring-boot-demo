package com.example.springbootdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springbootdemo.model.User;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

  IPage<User> selectPageVo(Page page);

  List<User> testListByLogicDelete();


}
