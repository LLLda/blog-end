package com.example.demo.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.example.demo.entity.Dishes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("bc_orderitem")
public class OrderItem implements Serializable {
    private Integer orderitem_id;
    private Integer count;
    private Integer order_id;
    private Integer dishes_id;
    public Dishes dishes;
}
