package com.example.demo.interfaces;

import com.example.demo.entity.Topic;
import com.example.demo.vo.TopicsVo;

import java.util.List;

public interface TopicInterface {
    List<TopicsVo> getTopicAll();
    List<TopicsVo> getTopicByClassify(Integer classifyId);
    String addTopic(String topicContent, Long topicTime, Integer userCId,Integer classifyId,String imgUrl);
    List<Topic> getTopicById(Integer topicId);
}
