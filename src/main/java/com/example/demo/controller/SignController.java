package com.example.demo.controller;

import com.example.demo.interfaces.SignInterface;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/sign")
public class SignController {
    @Resource
    private SignInterface signInterface;

    @GetMapping("/check")
    public String sign(@Param("userCId") Integer userCId,@Param("time") Long time){
        return signInterface.checkSign(userCId,time);
    }

    @GetMapping("/add")
    public String addSign(@Param("userCId") Integer userCId,@Param("time") Long time){
        return signInterface.addSign(userCId,time);
    }
}
