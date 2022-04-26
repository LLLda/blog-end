package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.demo.entity.Dishes;
import com.example.demo.entity.Menu;
import com.example.demo.interfaces.MenuInterface;
import com.example.demo.mapper.DishesMapper;
import com.example.demo.mapper.MenuMapper;
import com.example.demo.mapper.OrderMapper;
import com.example.demo.vo.GoodsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class MenuService implements MenuInterface {

    @Autowired
    private DishesMapper dishesMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<GoodsVO> getGoodsList(Long userId) {

        //根据用户id查询菜单列表
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId).eq("menu_status",1);

        List<Menu> menus = menuMapper.selectList(queryWrapper);

        System.out.println(menus);

        //归集菜单id
        List<Integer> menuIds = menus.stream().map(Menu::getMenu_id).collect(Collectors.toList());

        //根据菜单列表ids查询所有餐品;
        List<Dishes> listByMenuIds = dishesMapper.findListByMenuIds(menuIds);

        //把菜单id变成一个Map<菜单的id, 菜单对应的菜品的list>
        Map<Integer, List<Dishes>> collect = listByMenuIds.stream()
                .collect(Collectors.groupingBy(Dishes::getMenu_id));

        //最终结果List<GoodsVO>变量
        List<GoodsVO> result = new ArrayList<>();

        //遍历菜单列表填充数据
        menus.stream().forEach(item -> {
            GoodsVO goodsVO = new GoodsVO();
            List<Dishes> dishes = collect.get(item.getMenu_id());
            goodsVO.setId(item.getMenu_id());
            goodsVO.setName(item.getMenu_name());
            goodsVO.setGood_list(dishes);
            result.add(goodsVO);
        });

        return result;
    }

    @Override
    public List<Menu> findMenuListByUserId(Long userId) {
        //根据用户id查询菜单列表
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId).eq("menu_status",1);

        List<Menu> menus = menuMapper.selectList(queryWrapper);
        return menus;
    }

    @Override
    public String editMenu(Integer menuId,String menuName){
        UpdateWrapper<Menu> updateWrapper = new UpdateWrapper<>();
        Menu menu = new Menu();
        updateWrapper.eq("menu_id",menuId).set("menu_name",menuName);
        menuMapper.update(menu,updateWrapper);
        return "success";
    }

    @Override
    public String delMenu(Integer menuId){
        UpdateWrapper<Menu> updateWrapper = new UpdateWrapper<>();
        Menu menu = new Menu();
        updateWrapper.eq("menu_id",menuId).set("menu_status",0);
        menuMapper.update(menu,updateWrapper);
        return "success";
    }

    @Override
    public String addMenu(String menuName ,Integer userId){
        Menu menu = new Menu();
        menu.setMenu_name(menuName);
        menu.setMenu_status(1);
        menu.setUser_id(userId);
        menuMapper.insert(menu);
        return "success";
    }
}
