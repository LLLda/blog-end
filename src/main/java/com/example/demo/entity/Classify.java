package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_classify")
public class Classify {
    private Integer classify_id;
    private String classify_name;
    private String classify_des;
    private Integer classify_status;
}
