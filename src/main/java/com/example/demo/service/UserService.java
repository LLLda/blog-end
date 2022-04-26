package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.demo.entity.User;
import com.example.demo.interfaces.UserInterface;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserInterface {

    @Autowired
    private UserMapper userMapper;

    @Override
    public String login(Integer userId,String password){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",userId).eq("user_password",password);
        List<User> loginRes = userMapper.selectList(queryWrapper);
        if(loginRes.size() == 0){
            return "fail";
        }else{
            return "Success";
        }
    }

    @Override
    public List<User> getUserById(Integer userId){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",userId);
        List<User> userList = userMapper.selectList(queryWrapper);
        return userList;
    }

    @Override
    public String editUserById(Integer userId,String userName,String password,String userAddress,String storeName){
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        User user = new User();
        updateWrapper.eq("user_id",userId).set("user_id",userId).set("user_name",userName).set("user_password",password).set("user_address",userAddress).set("store_name",storeName);
        userMapper.update(user,updateWrapper);
        return "success";
    }
}
