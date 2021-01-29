package com.example.springboot.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot.demo.model.User;

public interface UserMapper extends BaseMapper<User> {

  IPage<User> selectPageVo(Page page);
}
