package com.edu.guraduration;

import com.edu.guraduration.entity.User;
import com.edu.guraduration.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@Slf4j
@SpringBootTest
class GuradurationApplicationTests {
    @Autowired
    UserService service;
    @Test
    void register() {
        User user = new User();
        user.setUserName("张三");
        user.setUserEmail("132456@qq.com");
        user.setUserPassword("123456");
        User newuser= service.insert(user);
        log.info(newuser.toString());
    }
    @Test
    void login(){
        User newuser = service.queryByNameAndPassword("张三","123456");
        log.info(newuser.toString());
    }
}
