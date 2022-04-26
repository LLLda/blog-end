package com.example.demo.interfaces;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Menu;
import com.example.demo.vo.GoodsVO;

import java.util.List;

public interface MenuInterface{

    /**
     * @param userId 用户id
     * */
    List<GoodsVO> getGoodsList(Long userId);

    List<Menu> findMenuListByUserId(Long userId);

    String editMenu(Integer menuId, String menuName);

    String delMenu(Integer menuId);

    String addMenu(String menuName, Integer userId);
}
