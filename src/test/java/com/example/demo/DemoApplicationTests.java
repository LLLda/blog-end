package com.example.demo;

import com.example.demo.entity.Dishes;
import com.example.demo.interfaces.OrderItemInterface;
import com.example.demo.mapper.OrderItemMapper;
import com.example.demo.mapper.OrderMapper;
import com.example.demo.vo.ItemsVO;
import com.example.demo.vo.OrderItem;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@SpringBootTest
class DemoApplicationTests {

	@Resource
	OrderItemMapper orderItemMapper;

	@Test
	void contextLoads() {
//		List<ItemsVO> items = orderItemInterface.getItems(15334562771l);
//		System.out.println(items);


		List<OrderItem> all = orderItemMapper.findAll(1000000);
		System.out.println(all);
	}

}
