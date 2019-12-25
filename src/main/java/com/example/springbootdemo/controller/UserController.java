package com.example.springbootdemo.controller;

import com.example.springbootdemo.model.DataArea;
import com.example.springbootdemo.model.User;
import com.example.springbootdemo.service.DataAreaService;
import com.example.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @Autowired
  UserService userService;

  @Autowired
  DataAreaService dataAreaService;

  @RequestMapping("/test")
  public void save() {
    User u1 = new User();
    u1.setId(3L);
    u1.setName("t");
    u1.setAge(1);
    u1.setEmail("t@qq.com");
    Thread t = new Thread(() -> userService.save(u1));
    User u2 = new User();
    u2.setId(3L);
    u2.setName("t1");
    u2.setAge(1);
    u2.setEmail("t@qq.com");
    Thread t1 = new Thread(() -> userService.save(u2));
    t1.start();
    t.start();

    System.out.println(112121);
  }

  @RequestMapping("/test1")
  public void test1() {
    User u1 = new User();
    u1.setName("t");
    u1.setAge(1);
    u1.setEmail("t@qq.com");
    userService.save(u1);
  }

  @RequestMapping("/test2")
  public DataArea test2() {
    return dataAreaService.selectOne(1L);
  }
}
