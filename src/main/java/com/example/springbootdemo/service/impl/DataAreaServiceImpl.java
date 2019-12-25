package com.example.springbootdemo.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.example.springbootdemo.mapper.DataAreaMapper;
import com.example.springbootdemo.model.DataArea;
import com.example.springbootdemo.service.DataAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@DS("#header.platform")//从header获取
public class DataAreaServiceImpl implements DataAreaService {

  @Autowired
  DataAreaMapper dataAreaMapper;


  @Override
  public DataArea selectOne(Long id) {
    return dataAreaMapper.selectById(id);
  }
}
