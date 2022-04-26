package com.example.demo.interfaces;

import com.example.demo.entity.Classify;

import java.util.List;

public interface ClassifyInterface {
//    获取所有分区信息
    List<Classify> getClassify();
//    分区信息更新（删除）
    String editClassify(Integer classifyId,Integer classifyStatus,String classifyName,String classifyDes);
//    新增分区
    String addClassify(String classifyName,String classifyDes);
}
