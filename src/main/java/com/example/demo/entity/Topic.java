package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_topic")
public class Topic {
    private Integer topic_id;
    private String topic_headline;
    private String topic_content;
    private Long topic_time;
    private Integer topic_status;
    private Integer userC_id;
    private Integer classify_id;
    private String topic_imgUrl;
}
