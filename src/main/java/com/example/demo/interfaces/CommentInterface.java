package com.example.demo.interfaces;

import com.example.demo.vo.CommentTopicVO;
import com.example.demo.vo.CommentsVo;
import com.example.demo.vo.LikeTopicVO;

import java.util.List;

public interface CommentInterface {
    List<CommentsVo> getCommentsAll(Integer topicId);
    String addComments(Integer userCId, Integer topicId,String commentContent,Long commentTime);
    List<CommentTopicVO> getCommentRecord(Integer userCId);
}
