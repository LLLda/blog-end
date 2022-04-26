package com.example.demo.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Menu;
import com.example.demo.entity.Order;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface OrderMapper extends BaseMapper<Order> {
    @Select("select * from bc_order where order_phone=#{order_phone}")
    Order findOrderByphone(Long phone);
}
