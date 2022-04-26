package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.demo.entity.Real;
import com.example.demo.entity.UserC;
import com.example.demo.interfaces.RealInterface;
import com.example.demo.mapper.RealMapper;
import com.example.demo.mapper.UserCMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RealService implements RealInterface {
    @Autowired
    private RealMapper realMapper;

    @Autowired
    private UserCMapper userCMapper;

    @Override
    public String checkRealInfo(Integer userCId,Long realNumber,String realName){
        QueryWrapper<Real> queryWrapper = new QueryWrapper();
        queryWrapper.eq("real_name",realName);
        queryWrapper.eq("real_Number",realNumber);
        List<Real> reals = realMapper.selectList(queryWrapper);

        if(reals.size()<=0 || reals==null){
            return "false";
        } else {
            UpdateWrapper<UserC> updateWrapper = new UpdateWrapper();
            UserC userC = new UserC();
            updateWrapper.eq("userC_Id",userCId).set("userC_realName",realName).set("userC_realNumber",realNumber).set("userC_realStatus",1);
            userCMapper.update(userC,updateWrapper);
            return "true";
        }
    }
}
