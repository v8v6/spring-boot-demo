package com.example.springbootdemo.mapper;

import com.example.springbootdemo.model.User;
import java.util.List;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserMapperTest {

  @Autowired
  private UserMapper userMapper;

  @Test
  public void testSelect() {
    System.out.println(("----- selectAll method test ------"));
    List<User> userList = userMapper.selectList(null);
    Assert.assertEquals(5, userList.size());
    userList.forEach(System.out::println);
  }

  @Test
  public void testMuiltThreadInsert() {
    User u1 = new User();
    u1.setId(1L);
    u1.setName("t");
    u1.setAge(1);
    u1.setEmail("t@qq.com");
    Thread t = new Thread(() -> userMapper.insert(u1));
    User u2 = new User();
    u2.setId(2L);
    u2.setName("t1");
    u2.setAge(1);
    u2.setEmail("t@qq.com");
    Thread t1 = new Thread(() -> userMapper.insert(u2));
    t1.start();
    t.start();
    System.out.println(1111);
    System.out.println(1111);
    System.out.println(1111);
    System.out.println(1111);
  }

}