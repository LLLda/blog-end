package com.example.demo.interfaces;

import com.example.demo.entity.OrderItem;
import com.example.demo.vo.ItemsVO;

import java.util.List;

public interface OrderItemInterface {
    List<OrderItem> getItemByOrderId(Integer orderId);

    List<ItemsVO> getItems(Long phone);

    String updateOrderItem(Integer orderId, Integer count, Integer dishesId);
}
