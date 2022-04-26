package com.example.demo.controller;

import com.example.demo.entity.UserC;
import com.example.demo.interfaces.UserCInterface;
import com.example.demo.interfaces.UserInterface;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/userC")
public class UserCController {
    @Resource
    private UserCInterface userCInterface;

    @GetMapping("/getUserCById")
    public List<UserC> getUserCById(@Param("userC_id") Integer userCId,@Param("userLogName") String userLogName){
        return userCInterface.getUserCById(userCId,userLogName);
    }

    @PostMapping("/editUserCById")
    public String editUserCById(@Param("userCId") Integer userCId,@Param("userCPwd") String userCPwd,@Param("userCName") String userCName,@Param("userCAge") Integer userCAge,@Param("userCSex") Integer userCSex,@Param("userCImgUrl") String userCImgUrl){
        return userCInterface.editUserCById(userCId,userCPwd,userCName,userCAge,userCSex,userCImgUrl);
    }

    @GetMapping("/editIntegral")
    public String editIntegral(@Param("userCId") Integer userCId,@Param("integral") Integer integral){
        return userCInterface.editIntegral(userCId,integral);
    }

    @PostMapping("/checkLoginInfo")
    public String checkLoginInfo(@Param("userLogName") String userLogName,@Param("userPwd") String userPwd){
        return userCInterface.checkLoginInfo(userLogName,userPwd);
    }

    @PostMapping("/addUserC")
    public String addUser(@Param("userCLogName") String userCLogName,@Param("userCPwd") String userCPwd,@Param("userCName") String userCName,@Param("userCImgUrl") String userCImgUrl){
        return userCInterface.addUser(userCLogName,userCPwd,userCName,userCImgUrl);
    }

}
