package com.example.demo.controller;

import com.example.demo.entity.Like;
import com.example.demo.interfaces.LikeInterface;
import com.example.demo.mapper.LikeMapper;
import com.example.demo.vo.LikeTopicVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("api/like")
public class LikeController {
    @Resource
    private LikeInterface likeInterface;

    @Resource
    private LikeMapper likeMapper;

    @GetMapping("/addLike")
    public String addLike(@Param("userCId") Integer userCId,@Param("topicId") Integer topicId){
        return likeInterface.addLike(userCId,topicId);
    }

    @GetMapping("/delLike")
    public String delLike(@Param("userCId") Integer userCId,@Param("topicId") Integer topicId){
        return likeInterface.delLike(userCId,topicId);
    }

    @GetMapping("/getLikeRecord")
    public List<LikeTopicVO> getLikeRecord(@Param("userCId") Integer userCId){
        return likeInterface.getLikeRecord(userCId);
    }

    @GetMapping("/checkLike")
    public String checkLike(@Param("userCId") Integer userCId,@Param("topicId") Integer topicId){
        return likeInterface.checkLike(userCId,topicId);
    }
}
