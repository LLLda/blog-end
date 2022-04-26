package com.example.demo.controller;

import com.example.demo.entity.UserB;
import com.example.demo.interfaces.UserBInterface;
import com.example.demo.interfaces.UserCInterface;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/userB")
public class UserBController {
    @Resource
    private UserBInterface userBInterface;

    @GetMapping("/check")
    public List<UserB> check(@Param("userBName") String userBName, @Param("userBPwd") String userBPwd){
        return userBInterface.CheckUserB(userBName,userBPwd);
    }

    @PostMapping("/edit")
    public String edit(@Param("userBId") Integer userBId,@Param("userBName") String userBName,@Param("userBPwd") String userBPwd){
        return userBInterface.editUserB(userBId,userBName,userBPwd);
    }
}
