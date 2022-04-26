package com.example.demo.controller;

import com.example.demo.interfaces.RealInterface;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/real")
public class RealController {
    @Resource
    private RealInterface realInterface;

    @PostMapping("/checkRealInfo")
    public String checkRealInfo(@Param("userCId") Integer userCId,@Param("realNumber") Long realNumber,@Param("realName") String realName){
        return realInterface.checkRealInfo(userCId,realNumber,realName);
    }

}
