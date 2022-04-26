package com.example.demo.controller;

import com.example.demo.entity.Order;
import com.example.demo.entity.OrderItem;
import com.example.demo.interfaces.OrderItemInterface;
import com.example.demo.mapper.OrderItemMapper;
import com.example.demo.mapper.OrderMapper;
import com.example.demo.vo.ItemsVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController

@RequestMapping("/api/getOrderItem")
public class OrderItemController {
    @Resource
    private OrderMapper orderMapper;

    @Resource
    private OrderItemInterface orderItemInterface;

    @GetMapping("/byOrderId")
    public List<OrderItem> getItemByOrderId(@Param("Id") Integer Id) {
        return orderItemInterface.getItemByOrderId(Id);
    }

    @GetMapping("/byPhone")
    public List<ItemsVO> getItemsByPhone(@Param("phone") Long phone) {
        return orderItemInterface.getItems(phone);
    }

    @PostMapping("/updateOrderItem")
    public String insertOrderItem(@Param("orderId") Integer orderId, @Param("count") Integer count,@Param("dishesId") Integer dishesId){
        return orderItemInterface.updateOrderItem(orderId,count,dishesId);
    }
}
