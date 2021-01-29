package com.example.springboot.demo.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "t_user")
public class User {
  private Long id;
  private String name;
  private String email;
  private Integer sex;
  private String phone;
  private String password;
}
