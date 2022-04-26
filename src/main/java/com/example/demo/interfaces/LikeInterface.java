package com.example.demo.interfaces;


import com.example.demo.vo.LikeTopicVO;

import java.util.List;

public interface LikeInterface {
    String addLike(Integer userCId,Integer topicId);
    List<LikeTopicVO> getLikeRecord(Integer userCId);
    String checkLike(Integer userCId,Integer topicId);
    String delLike(Integer userCId,Integer topicId);
}
