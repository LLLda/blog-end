package com.example.demo.vo;

import com.example.demo.entity.Topic;
import lombok.Data;

import java.util.List;

@Data
public class CommentTopicVO {
    private Integer commentId;
    private String commentContent;
    private List<Topic> topics;
}
