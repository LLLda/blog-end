package com.example.demo.controller;

import com.example.demo.entity.Topic;
import com.example.demo.interfaces.TopicInterface;
import com.example.demo.vo.TopicsVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/topic")
public class TopicController {
    @Resource
    TopicInterface topicInterface;

    @GetMapping("/getTopicAll")
    public List<TopicsVo> getTopicAll(){
        return topicInterface.getTopicAll();
    }

    @GetMapping("/getTopicByClassify")
    public List<TopicsVo> getTopicByClassify(@Param("classifyId") Integer classifyId){
        return topicInterface.getTopicByClassify(classifyId);
    }

    @PostMapping("/addTopic")
    public String addTopic(@Param("topicContent") String topicContent,@Param("topicTime") Long topicTime,@Param("userCId") Integer userCId,@Param("classifyId") Integer classifyId,@Param("imgUrl") String imgUrl){
        return topicInterface.addTopic(topicContent,topicTime,userCId,classifyId,imgUrl);
    }

    @GetMapping("/getTopicById")
    public List<Topic> getTopicById(@Param("topicId") Integer topicId){
        return topicInterface.getTopicById(topicId);
    }
}
