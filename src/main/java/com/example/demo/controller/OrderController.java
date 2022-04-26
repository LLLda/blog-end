package com.example.demo.controller;

import com.example.demo.entity.Order;
import com.example.demo.interfaces.OrderInterface;
import com.example.demo.mapper.OrderMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController

@RequestMapping("/api/getOrder")
public class OrderController {
    @Resource
    private OrderMapper orderMapper;

    @Resource
    private OrderInterface orderInterface;

    @PostMapping()
    public String insert(@Param("orderId") Integer orderId,@Param("userId") Integer userId, @Param("number") Integer number, @Param("time") String time, @Param("des") String des,@Param("phone") Long phone,@Param("phone") Integer type){
        return orderInterface.updateOrder(orderId, userId, number, time, des, phone,type);
    }

    @GetMapping("/byPhone")
    public List<Order> getOrderByphone(@Param("phone") Long phone,@Param("id") Integer id) {
        return orderInterface.getOrderByphone(phone);
    }

    @GetMapping("/byUserId")
    public List<Order> getOrderByUserId(@Param("userId") Integer userId) {
        return orderInterface.getOrderByUserId(userId);
    }

    @GetMapping("/byId")
    public List<Order> getOrderById(@Param("id") Integer id) {
        return orderInterface.getOrderById(id);
    }

    @GetMapping("/byStatus")
    public List<Order> getOrderByStatus(@Param("status") Integer status,@Param("userId") Integer userId) { return orderInterface.getOrderByStatus(status,userId); }

    @GetMapping("/changeById")
    public String changeStatus(@Param("id") Integer id){
        return orderInterface.updateStatusById(id);
    }

    @GetMapping("/getTodayOrder")
    public List<Order> getTodayOrderByTime(@Param("time") String time, @Param("userId") Integer userId) { return orderInterface.getTodayOrderByTime(time, userId); }
}
