package com.example.demo.interfaces;

import com.example.demo.entity.Dishes;
import com.example.demo.entity.Order;

import java.util.List;

public interface OrderInterface {
    String updateOrder(Integer orderId,Integer userId, Integer number, String time, String des, Long phone,Integer type);
    List<Order> getOrderByphone(Long phone);
    List<Order> getOrderByUserId(Integer userId);
    List<Order> getOrderByStatus(Integer status, Integer userId);
    List<Order> getOrderById(Integer id);
    String updateStatusById(Integer orderId);
    List<Order> getTodayOrderByTime(String time,Integer orderId);
}
