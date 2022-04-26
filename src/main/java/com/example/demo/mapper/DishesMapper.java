package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Dishes;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface DishesMapper extends BaseMapper<Dishes> {

//    @Select("select * from bc_dishes")
//    List<Dishes> findAll();

    List<Dishes> findListByMenuIds(@Param("menuIds") List<Integer> menuIds);
    List<Dishes> findListByDishesIds(@Param("dishesIds") List<Integer> dishesIds);
}
