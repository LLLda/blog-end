package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Dishes;
import com.example.demo.entity.Menu;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface MenuMapper extends BaseMapper<Menu> {

//    @Select("select * from bc_menu where user_id = #{userId}")
////    @Select("select * from bc_menu,bc_dishes where bc_menu.menu_id = bc.dishes.menu_id")
//    List<Menu> findAll(@Param("userId") Long userId);
}
