package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.demo.entity.UserB;
import com.example.demo.interfaces.UserBInterface;
import com.example.demo.mapper.UserBMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserBService implements UserBInterface {
    @Autowired
    private UserBMapper userBMapper;

    @Override
    public List<UserB> CheckUserB(String userBName, String userBPwd){
        QueryWrapper<UserB> queryWrapper = new QueryWrapper();
        queryWrapper.eq("userB_name",userBName).eq("userB_pwd",userBPwd);
        List<UserB> userBS = userBMapper.selectList(queryWrapper);
        List<UserB> userEmpty = new ArrayList<>();
        if(userBS.size()>0){
            return userBS;
        }else {
            return userEmpty;
        }
    }

    @Override
    public String editUserB(Integer userBId,String userBName,String userBPwd){
        UpdateWrapper<UserB> updateWrapper = new UpdateWrapper<>();
        UserB userB = new UserB();
        updateWrapper.eq("userB_id",userBId).set("userB_name",userBName).set("userB_pwd",userBPwd);
        Integer re = userBMapper.update(userB,updateWrapper);
        if(re>0){
            return "success";
        } else {
            return "fail";
        }

    }
}
