package com.example.demo.controller;

import com.example.demo.interfaces.CommentInterface;
import com.example.demo.vo.CommentTopicVO;
import com.example.demo.vo.CommentsVo;
import com.example.demo.vo.LikeTopicVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/comment")
public class CommentController {
    @Resource
    private CommentInterface commentInterface;

    @GetMapping("/getCommentsAll")
    public List<CommentsVo> getCommentsAll(@Param("topicId") Integer topicId){
        return commentInterface.getCommentsAll(topicId);
    }
    @PostMapping("/addComment")
    public String addComment(@Param("userCId") Integer userCId,@Param("topicId") Integer topicId,@Param("commentContent") String commentContent,@Param("commentTime") Long commentTime){
        return commentInterface.addComments( userCId, topicId, commentContent, commentTime);
    }

    @GetMapping("/getCommentRecord")
    public List<CommentTopicVO> getCommentRecord(@Param("userCId") Integer userCId){
        return commentInterface.getCommentRecord(userCId);
    }
}
