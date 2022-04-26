package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_like")
public class Like {
    private Integer like_id;
    private Integer userC_id;
    private Integer topic_id;
}
