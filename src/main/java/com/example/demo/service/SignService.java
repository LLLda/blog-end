package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.Sign;
import com.example.demo.interfaces.SignInterface;
import com.example.demo.mapper.SignMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignService implements SignInterface {
    @Autowired
    private SignMapper signMapper;

    @Override
    public String checkSign(Integer userCId,Long time){
        QueryWrapper<Sign> queryWrapper = new QueryWrapper();
        queryWrapper.ge("sign_time",time).eq("userC_id",userCId);
        List<Sign> signList = signMapper.selectList(queryWrapper);
        if(signList.size() == 0){
            return "false";
        } else {
            return "true";
        }
    }
    @Override
    public String addSign(Integer userCId,Long time){
        Sign sign = new Sign();
        sign.setSign_time(time);
        sign.setUserC_id(userCId);
        signMapper.insert(sign);
        return "success";
    }
}
