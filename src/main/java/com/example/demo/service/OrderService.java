package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.demo.entity.Menu;
import com.example.demo.entity.Order;
import com.example.demo.interfaces.OrderInterface;
import com.example.demo.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements OrderInterface {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public String updateOrder(Integer orderId,Integer userId, Integer number, String time, String des, Long phone,Integer type){
        Order orderData = new Order();
        orderData.setOrder_id(orderId);
        orderData.setOrder_number(number);
        orderData.setOrder_time(time);
        orderData.setOrder_des(des);
        orderData.setOrder_phone(phone);
        orderData.setOrder_type(type);
        orderData.setUser_id(userId);
        int res = orderMapper.insert(orderData);
        return "上传订单信息成功";
    }

    @Override
    public List<Order> getOrderByphone(Long phone){
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("order_phone", phone);
        List<Order> orderList = orderMapper.selectList(queryWrapper);
        return orderList;
    }


//    根据用户id获取所有订单信息
    @Override
    public List<Order> getOrderByUserId(Integer Id){
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", Id).orderByDesc("order_time");
        List<Order> orderList = orderMapper.selectList(queryWrapper);
        return orderList;
    }

    @Override
    public List<Order> getOrderById(Integer id){
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("order_id", id);
        List<Order> orderList = orderMapper.selectList(queryWrapper);
        return orderList;
    }

    @Override
    public List<Order> getOrderByStatus(Integer status,Integer userId){
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("order_status",status).eq("user_id",userId);
        List<Order> orderList = orderMapper.selectList(queryWrapper);
        return orderList;
    }

    @Override
    public String updateStatusById(Integer id){
        UpdateWrapper<Order> updateWrapper = new UpdateWrapper();
        Order order = new Order();
        updateWrapper.eq("order_id",id).set("order_status",1);
        orderMapper.update(order,updateWrapper);
        return "success";
    }

    @Override
    public List<Order> getTodayOrderByTime(String time,Integer userId){
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("order_time",time).eq("user_id",userId);
        List<Order> orderList = orderMapper.selectList(queryWrapper);
        return orderList;
    }
}
