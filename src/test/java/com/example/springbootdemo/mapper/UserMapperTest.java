package com.example.springbootdemo.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springbootdemo.model.User;
import java.util.List;

import com.example.springbootdemo.service.UserDBService;
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

  @Autowired
  private UserDBService userDBService;

  @Test
  public void testSelect() {
    System.out.println(("----- selectAll method test ------"));
    List<User> userList = userMapper.selectList(null);
    Assert.assertEquals(5, userList.size());
    userList.forEach(System.out::println);
  }

  @Test
  public void testSelectPage() {
    System.out.println(("----- selectAll method test ------"));
    Page<User> page = new Page(0,2);
    IPage<User> selectPageVo = userMapper.selectPageVo(page);
    System.out.println(selectPageVo);
  }

    @Test
    public void testListByLogicDelete() {
        System.out.println(("----- selectAll method test ------"));
        List<User> list = userDBService.testListByLogicDelete();
        System.out.println(list);
    }

    @Test
    public void testLogicDelete() {
        System.out.println(("----- selectAll method test ------"));

        List<User> list = userDBService.list();
        System.out.println(list);
    }

}