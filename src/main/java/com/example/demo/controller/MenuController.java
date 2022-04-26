package com.example.demo.controller;

import com.example.demo.entity.Dishes;
import com.example.demo.entity.Menu;
import com.example.demo.interfaces.MenuInterface;
import com.example.demo.mapper.MenuMapper;
import com.example.demo.vo.GoodsVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("api/menuList")
public class MenuController {
    @Resource
    private MenuInterface menuInterface;

    @GetMapping
    public List<GoodsVO> findMenu(@Param("userId") Long userId) {
        return menuInterface.getGoodsList(userId);
    }

    @GetMapping("/byUserId")
    public List<Menu> findMenuListByUserId(@Param("userId") Long userId){
        return menuInterface.findMenuListByUserId(userId);
    }

    @GetMapping("/delMenu")
    public String delMenu(@Param("menuId") Integer menuId){
        return menuInterface.delMenu(menuId);
    }

    @GetMapping("/editMenu")
    public String editMenu(@Param("menuId") Integer menuId,@Param("menuName") String menuName){
        return menuInterface.editMenu(menuId,menuName);
    }

    @GetMapping("/addMenu")
    public String addMenu(@Param("userId") Integer userId,@Param("menuName") String menuName){
        return menuInterface.addMenu(menuName,userId);
    }
}
