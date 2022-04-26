package com.example.demo.controller;

import com.example.demo.interfaces.CollectInterface;
import com.example.demo.vo.CollectTopicVO;
import com.example.demo.vo.CommentTopicVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/collect")
public class CollectController {
    @Resource
    CollectInterface collectInterface;

    @GetMapping("/addCollect")
    public String addCollect(@Param("userCId") Integer userCId,@Param("topicId") Integer topicId){
        return collectInterface.addCollect(userCId,topicId);
    }

    @GetMapping("/delCollect")
    public String delCollect(@Param("userCId") Integer userCId,@Param("topicId") Integer topicId){
        return collectInterface.delCollect(userCId,topicId);
    }

    @GetMapping("/getCollectRecord")
    public List<CollectTopicVO> getCollectRecord(@Param("userCId") Integer userCId){
        return collectInterface.getCollectRecord(userCId);
    }

    @GetMapping("/checkCollect")
    public String checkCollect(@Param("userCId") Integer userCId,@Param("topicId") Integer topicId){
        return collectInterface.checkCollect(userCId,topicId);
    }
}
