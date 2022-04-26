package com.example.demo.controller;

import com.example.demo.entity.Classify;
import com.example.demo.interfaces.ClassifyInterface;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/classify")
public class ClassifyController {
    @Resource
    ClassifyInterface classifyInterface;

    @GetMapping("/getList")
    public List<Classify> getClassify(){
        return classifyInterface.getClassify();
    }

    @PostMapping("/edit")
    public String editClassify(@Param("classifyId") Integer classifyId,@Param("classifyStatus") Integer classifyStatus,@Param("classifyName") String classifyName,@Param("classifyDes") String classifyDes){
        return classifyInterface.editClassify( classifyId, classifyStatus, classifyName, classifyDes);
    }

    @PostMapping("/add")
    public String addClassify(@Param("classifyName") String classifyName,@Param("classifyDes") String classifyDes){
        return classifyInterface.addClassify(classifyName,classifyDes);
    }
}
