package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_sign")
public class Sign {
    private Integer sign_id;
    private Integer userC_id;
    private Long sign_time;
}
