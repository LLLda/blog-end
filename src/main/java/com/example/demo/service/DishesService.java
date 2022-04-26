package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.demo.entity.Dishes;
import com.example.demo.interfaces.DishesInterface;
import com.example.demo.mapper.DishesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;
import java.util.List;

@Service
public class DishesService implements DishesInterface {
    @Autowired
    DishesMapper dishesMapper;

    @Override
    public List<Dishes> getDishesByMenuId(Integer menuId,Integer dishesId){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("menu_id",menuId);
        queryWrapper.eq("dishes_status",1);
        queryWrapper.or();
        queryWrapper.eq("dishes_id",dishesId);
        queryWrapper.eq("dishes_status",1);
        List<Dishes> res = dishesMapper.selectList(queryWrapper);
        return res;
    }

    @Override
    public String editDishes(Integer dishesId, String dishesName,String dishesContent,Float dishesPrice,Integer menuId,String dishesImgUrl){
        UpdateWrapper<Dishes> updateWrapper = new UpdateWrapper();
        Dishes dishes = new Dishes();
        updateWrapper.eq("dishes_id",dishesId).set("dishes_name",dishesName).set("dishes_content",dishesContent).set("menu_id",menuId).set("dishes_price",dishesPrice).set("dishes_imgUrl",dishesImgUrl);
        dishesMapper.update(dishes,updateWrapper);
        return "success";
    }

    @Override
    public String delDishes(Integer dishesId){
        UpdateWrapper<Dishes> updateWrapper = new UpdateWrapper();
        Dishes dishes = new Dishes();
        updateWrapper.eq("dishes_id",dishesId).set("dishes_status",0);
        dishesMapper.update(dishes,updateWrapper);
        return "success";
    }

    @Override
    public String addDishes(String dishesName,String dishesContent,Float dishesPrice,Integer menuId,String dishesImgUrl){
//        Dishes dishes = new Dishes();
//        dishes.setDishes_content(dishesContent);
//        dishes.setDishes_name(dishesName);
//        dishes.setDishes_price(dishesPrice);
//        dishes.setDishes_imgUrl(dishesImgUrl);
//        dishes.setMenu_id(menuId);
//        dishesMapper.insert(dishes);

        Dishes dishes = new Dishes();
        dishes.setDishes_price(dishesPrice);
        dishes.setDishes_name(dishesName);
        dishes.setDishes_content(dishesContent);
        dishes.setDishes_imgUrl(dishesImgUrl);
        dishes.setMenu_id(menuId);
        dishesMapper.insert(dishes);
        return "success";
    }
}
