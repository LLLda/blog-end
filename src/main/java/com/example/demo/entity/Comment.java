package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_comment")
public class Comment {
    private Integer comment_id;
    private String comment_content;
    private Long comment_time;
    private Integer userC_id;
    private Integer topic_id;
}
