package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("bc_orderitem")
public class OrderItem {
    private Integer orderitem_id;
    private Integer count;
    private Integer order_id;
    private Integer dishes_id;
    private Dishes dishes;
}
