package com.ssmdemo.service;

import com.alibaba.fastjson.JSON;
import com.ssmdemo.dao.entity.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:config/spring-mybatis.xml"})
public class UserServiceTest {
    @Resource
    private UserService userService;
    @Autowired
    private UserEntity userEntity;

    @Test
    public void testCreateUser() throws Exception {

//        userEntity = userService.addUser(1,"kk","kkk");
//        userService.createUserByObject(userEntity);
//        System.out.println(JSON.toJSONString(userEntity));
    }

    @Test
    public void testDeleteUser() throws Exception {
        userService.deleteUser(2);
    }


}