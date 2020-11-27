package com.example.springbootdemo.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "t_user")
public class User {
  private Long id;
  private String name;
  private Integer age;
  private String email;
}
