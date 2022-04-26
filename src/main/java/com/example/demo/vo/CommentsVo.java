package com.example.demo.vo;

import com.example.demo.entity.Comment;
import com.example.demo.entity.UserC;
import lombok.Data;

import java.util.List;

@Data
public class CommentsVo {
    private List<Comment> comments;
    private List<UserC> userCS;
}
