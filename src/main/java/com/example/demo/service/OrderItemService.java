package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.Order;
import com.example.demo.entity.OrderItem;
import com.example.demo.interfaces.OrderItemInterface;
import com.example.demo.mapper.DishesMapper;
import com.example.demo.mapper.OrderItemMapper;
import com.example.demo.mapper.OrderMapper;
import com.example.demo.vo.ItemsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OrderItemService implements OrderItemInterface {
    @Autowired
    private OrderItemMapper orderItemMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private DishesMapper dishesMapper;

    @Override
    public List<OrderItem> getItemByOrderId(Integer orderId){
        QueryWrapper<OrderItem> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("order_id", orderId);

        List<OrderItem> orderItemsList = orderItemMapper.selectList(queryWrapper);

        return orderItemsList;
    }

    @Override
    public String updateOrderItem(Integer orderId, Integer count, Integer dishesId){
        OrderItem orderItemData = new OrderItem();
        orderItemData.setOrder_id(orderId);
        orderItemData.setCount(count);
        orderItemData.setDishes_id(dishesId);
        int res = orderItemMapper.insert(orderItemData);
        return "上传子订单信息成功";
    }

    @Override
    public List<ItemsVO> getItems(Long phone){
        //根据电话和订单状态查询订单id
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("order_phone", phone);
        queryWrapper.eq("order_status", 0);

        List<Order> orders = orderMapper.selectList(queryWrapper);

        //归集订单id
        List<Integer> orderIds = orders.stream().map(Order::getOrder_id).collect(Collectors.toList());

        //根据订单列表ids查询所有子订单;
        List<OrderItem> listByOrderIds = orderItemMapper.findListByOrderIds(orderIds);

        //把订单id变成一个Map<订单的id, 订单对应的子订单的list>
        Map<Integer, List<OrderItem>> collect = listByOrderIds.stream()
                .collect(Collectors.groupingBy(OrderItem::getOrder_id));

        //最终结果List<ItemsVO>变量
        List<ItemsVO> result = new ArrayList<>();

        //遍历订单列表填充数据
        orders.stream().forEach(item -> {
            ItemsVO itemsVO = new ItemsVO();
            List<OrderItem> orderItem = collect.get(item.getOrder_id());
            itemsVO.setId(item.getOrder_id());
            itemsVO.setNumber(item.getOrder_number());
            itemsVO.setTime(item.getOrder_time());
            itemsVO.setType(item.getOrder_type());
            itemsVO.setOrderItems(orderItem);
            result.add(itemsVO);
        });
        return result;
    }
}
