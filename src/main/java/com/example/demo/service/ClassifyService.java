package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.demo.entity.Classify;
import com.example.demo.interfaces.ClassifyInterface;
import com.example.demo.mapper.ClassifyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClassifyService implements ClassifyInterface {
    @Autowired
    ClassifyMapper classifyMapper;

    @Override
    public List<Classify> getClassify(){
        QueryWrapper<Classify> queryWrapper = new QueryWrapper();
        queryWrapper.eq("classify_status",1);
        List<Classify> res =  classifyMapper.selectList(queryWrapper);
        return res;
    }

    @Override
    public String editClassify(Integer classifyId,Integer classifyStatus,String classifyName,String classifyDes){
        UpdateWrapper<Classify> updateWrapper = new UpdateWrapper();
        Classify classify = new Classify();
        if(classifyStatus!=null){
            updateWrapper.eq("classify_id",classifyId).set("classify_status",0);
        } else {
            updateWrapper.eq("classify_id",classifyId).set("classify_name",classifyName).set("classify_des",classifyDes);
        }
        Integer re = classifyMapper.update(classify,updateWrapper);
        if(re==0){
            return "fail";
        }else{
            return "success";
        }
    }

    @Override
    public String addClassify(String classifyName,String classifyDes){
        Classify classify = new Classify();
        classify.setClassify_des(classifyDes);
        classify.setClassify_name(classifyName);
        Integer re = classifyMapper.insert(classify);
        if(re==0){
            return "fail";
        }else{
            return "success";
        }
    }
}
