package com.green.springboot.controller;

import com.green.springboot.entity.User;
import com.green.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/*
使用jpa方式查询数据库
 */
@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/userAll")
    public List<User> findAll(){
        List<User> users = userRepository.findAll();
        System.out.println("用户信息列表为："+users.toArray());
        return users;
    }
   @RequestMapping("/user")
    public User insertUser(User user){
        userRepository.saveAndFlush(user);
        return user;
    }

    @RequestMapping("/user/{id}")
    public List<User> getUserById(@PathVariable("id") Integer id){
        List<User> users = userRepository.findById(id);
        System.out.println("用户信息列表为："+users.toArray());
        return users;
    }
}
