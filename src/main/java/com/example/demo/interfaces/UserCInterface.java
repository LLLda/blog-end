package com.example.demo.interfaces;

import com.example.demo.entity.UserC;

import java.util.List;

public interface UserCInterface {
    List<UserC> getUserCById(Integer userCId,String userLogName);
    String editUserCById(Integer userCId,String userCPwd,String userCName,Integer userCAge,Integer userCSex,String userCImgUrl);
    String editIntegral(Integer userCId,Integer integral);
    String checkLoginInfo(String userLogName,String userPwd);
    String addUser(String userCLogName,String userCPwd, String userCName,String userCImgUrl);
}
