package com.example.demo.vo;

import com.example.demo.entity.Topic;
import com.example.demo.entity.UserC;
import lombok.Data;

import java.util.List;

@Data
//帖子全部信息 帖子信息、用户信息、点赞数、收藏
public class TopicsVo {
    List<Topic> topics;
    Integer likes;
    Integer comments;
    Integer collects;
    List<UserC> userCS;
}
