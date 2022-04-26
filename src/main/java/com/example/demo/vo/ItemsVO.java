package com.example.demo.vo;

import com.example.demo.entity.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemsVO {
    /**
     * 订单id
     * */
    private Integer id;

    /**
     * 订单取号码
     * */
    private Integer number;

    /**
     * 订单下单时间
     * */
    private String time;

    /**
     * 订单类型
     * */
    private Integer type;

    /**
     * 子订单列表
     * */
    private List<OrderItem> orderItems;
}
