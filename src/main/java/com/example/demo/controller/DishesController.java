package com.example.demo.controller;

import com.example.demo.entity.Dishes;
import com.example.demo.interfaces.DishesInterface;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("api/Dishes")
public class DishesController {
    @Resource
    private DishesInterface dishesInterface;

    @GetMapping("/getByMenuId")
    public List<Dishes> getDishesList(@Param("menuId") Integer menuId,@Param("dishesId") Integer dishesId){
        return dishesInterface.getDishesByMenuId(menuId,dishesId);
    }

    @GetMapping("/delById")
    public String delDishes(@Param("dishesId") Integer dishesId){
        return dishesInterface.delDishes(dishesId);
    }

    @PostMapping("/editById")
    public String editDishes(@Param("dishesId") Integer dishesId,@Param("dishesName") String dishesName,@Param("dishesContent") String dishesContent,@Param("dishesPrice") Float dishesPrice, @Param("menuId") Integer menuId,@Param("dishesImgUrl") String dishesImgUrl){
        return dishesInterface.editDishes(dishesId, dishesName, dishesContent, dishesPrice,menuId, dishesImgUrl);
    }

    @PostMapping("/addDishes")
    public String addDishes(@Param("dishesName") String dishesName,@Param("dishesContent") String dishesContent,@Param("dishesPrice") Float dishesPrice,@Param("menuId") Integer menuId,@Param("dishesImgUrl") String dishesImgUrl){
        return dishesInterface.addDishes(dishesName,dishesContent,dishesPrice,menuId,dishesImgUrl);
    }
}
