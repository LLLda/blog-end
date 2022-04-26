package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_announcement")
public class Announcement {
    private Integer announcement_id;
    private String announcement_headline;
    private String announcement_content;
    private Long announcement_time;
    private Integer announcement_status;
}
