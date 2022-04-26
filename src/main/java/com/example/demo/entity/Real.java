package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_real")
public class Real {
    private Integer real_id;
    private String real_name;
    private Long real_number;
}
