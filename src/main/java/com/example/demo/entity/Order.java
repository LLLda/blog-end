package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("bc_order")
public class Order {
    private Integer order_id;
    private Long order_phone;
    private Integer order_number;
    private String order_time;
    private String order_des;
    private Integer order_type;
    private Integer order_status;
    private Integer user_id;
}
