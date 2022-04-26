package com.example.demo.interfaces;

import com.example.demo.vo.CollectTopicVO;

import java.util.List;

public interface CollectInterface {
    String addCollect(Integer userCId,Integer topicId);
    List<CollectTopicVO> getCollectRecord(Integer userCId);
    String checkCollect(Integer userCId,Integer topicId);
    String delCollect(Integer userCId,Integer topicId);
}
