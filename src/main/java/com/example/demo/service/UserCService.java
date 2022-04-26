package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.demo.entity.Menu;
import com.example.demo.entity.Real;
import com.example.demo.entity.UserC;
import com.example.demo.interfaces.UserCInterface;
import com.example.demo.mapper.UserCMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCService implements UserCInterface {
    @Autowired
    private UserCMapper userCMapper;

    @Override
    public List<UserC> getUserCById(Integer userCId,String userLogName){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("userC_id",userCId);
        queryWrapper.or();
        queryWrapper.eq("userC_logName",userLogName);
        List<UserC> userCS = userCMapper.selectList(queryWrapper);
        return userCS;
    }

    @Override
    public String editUserCById(Integer userCId,String userCPwd,String userCName,Integer userCAge,Integer userCSex,String userCImgUrl){
        UpdateWrapper<UserC> updateWrapper = new UpdateWrapper();
        UserC userC = new UserC();
        updateWrapper.eq("userC_Id",userCId).set("userC_pwd",userCPwd).set("userC_name",userCName).set("userC_age",userCAge).set("userC_sex",userCSex).set("userC_imgUrl",userCImgUrl);
        userCMapper.update(userC,updateWrapper);
        return "success";
    }
    @Override
    public String editIntegral(Integer userCId,Integer integral){
        UpdateWrapper<UserC> updateWrapper = new UpdateWrapper<>();
        UserC userC = new UserC();
        updateWrapper.eq("userC_Id",userCId).set("userC_integral",integral);
        userCMapper.update(userC,updateWrapper);
        return "success";
    }

    @Override
    public String checkLoginInfo(String userLogName,String userPwd){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("userC_logName",userLogName);
        queryWrapper.eq("userC_pwd",userPwd);
        List<Real> reals = userCMapper.selectList(queryWrapper);
        if(reals.size()<=0 || reals==null){
            return "false";
        } else {
            return "true";
        }
    }

    @Override
    public String addUser(String userCLogName,String userCPwd, String userCName,String userCImgUrl){
        UserC userC = new UserC();
        userC.setUserC_imgUrl(userCImgUrl);
        userC.setUserC_logName(userCLogName);
        userC.setUserC_pwd(userCPwd);
        userC.setUserC_name(userCName);
        userCMapper.insert(userC);
        return "success";
    }
}
