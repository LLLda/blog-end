package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.OrderItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderItemMapper extends BaseMapper<OrderItem> {
    List<OrderItem> findListByOrderIds(@Param("orderIds") List<Integer> orderIds);
    List<com.example.demo.vo.OrderItem> findAll(int orderIds);
}
