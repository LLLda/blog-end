package com.example.demo.interfaces;

import com.example.demo.entity.UserB;

import java.util.List;

public interface UserBInterface {
    List<UserB> CheckUserB(String userBName, String userBPwd);
    String editUserB(Integer userBId,String userBName,String userBPwd);
}
