package com.example.springbootdemo;

import com.baomidou.dynamic.datasource.provider.DynamicDataSourceProvider;
import com.example.springbootdemo.dynamic.datasource.CustomJdbcDataSourceProvider;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
@MapperScan(basePackages = "com.example.springbootdemo.mapper")
public class SpringBootDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringBootDemoApplication.class, args);
  }

  @Bean
  @ConditionalOnMissingBean
  public DynamicDataSourceProvider dynamicDataSourceProvider() {
    return new CustomJdbcDataSourceProvider("com.mysql.cj.jdbc.Driver",
        "jdbc:mysql://127.0.0.1:3306/muilt_data_source?useUnicode=true&characterEncoding=utf8&autoReconnect=true&useSSL=false",
        "root", "root");
  }

}
