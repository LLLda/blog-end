package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.interfaces.UserInterface;
import com.example.demo.mapper.UserMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserInterface userInterface;

    @GetMapping
    public List<User> getUser(){
        return userMapper.findAllUser();
    }

    @GetMapping("/login")
    public String login(@Param("userId") Integer userId,@Param("password") String password) {return userInterface.login(userId,password);}

    @GetMapping("/getUserById")
    public List<User> getUserById(@Param("userId") Integer userId){return userInterface.getUserById(userId);}

    @PostMapping("/editUser")
    public String editUser(@Param("userId") Integer userId,@Param("userName") String userName,@Param("password") String password,@Param("userAddress") String userAddress,@Param("storeName") String storeName){
        return userInterface.editUserById(userId,userName,password,userAddress,storeName);
    }
}
