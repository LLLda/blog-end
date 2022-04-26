package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_collect")
public class Collect {
    private Integer collect_id;
    private Integer userC_id;
    private Integer topic_id;
}
