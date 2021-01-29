package com.example.springboot.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot.demo.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author chenjunxi02
 * @Date 2021/1/4
 */

@RunWith(SpringRunner.class)
@SpringBootTest(value = {"application.yml"})
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void testSave() {
        System.out.println(("----- save method test ------"));
        User user = new User();
        user.setId(0L);
        user.setName("testSave");
        user.setEmail("testSave@qq.com");
        user.setSex(0);
        user.setPhone("testSave");
        user.setPassword("testSave");

        boolean save = userService.save(user);
        System.out.println(user);
        System.out.println(save);
    }

    @org.junit.jupiter.api.Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userService.list(null);
        userList.forEach(System.out::println);
    }

    @org.junit.jupiter.api.Test
    public void testSelectPage() {
        System.out.println(("----- selectAll method test ------"));
        Page<User> page = new Page(0, 2);
        IPage<User> selectPageVo = userService.page(page);
        System.out.println(selectPageVo);
    }
}
