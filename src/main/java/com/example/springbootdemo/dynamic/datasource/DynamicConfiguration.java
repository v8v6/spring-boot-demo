package com.example.springbootdemo.dynamic.datasource;

import com.baomidou.dynamic.datasource.DynamicDataSourceConfigure;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class DynamicConfiguration {

  //@Bean
  public DynamicDataSourceConfigure dynamicDataSourceConfigure() {
    return DynamicDataSourceConfigure.config()
        // 正则表达式
        //.regexMatchers("com.example.springbootdemo.service.impl.DataAreaServiceImpl.*.*", "#header.platform")
        // 切面
        .expressionMatchers("execution(* com.example.springbootdemo.service.impl.DataAreaServiceImpl.*(..))", "#header.platform")
        ;
  }
}
