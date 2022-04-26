package com.example.demo.interfaces;

import com.example.demo.entity.Dishes;

import java.util.List;

public interface DishesInterface {
    List<Dishes> getDishesByMenuId(Integer menuId, Integer DishesId);
    String editDishes(Integer dishesId, String dishesName,String dishes_content,Float dishes_price,Integer menu_id,String dishes_imgUrl);

    String delDishes(Integer dishesId);

    String addDishes(String dishesName,String dishesContent,Float dishesPrice,Integer menuId,String dishesImgUrl);
}
