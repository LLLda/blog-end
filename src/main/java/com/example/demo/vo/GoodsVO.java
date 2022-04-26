package com.example.demo.vo;

import com.example.demo.entity.Dishes;
import lombok.Data;

import java.util.List;

@Data
public class GoodsVO {

    /**
     * 菜单id
     * */
    private Integer id;

    /**
     * 食物列表
     * */
    private List<Dishes> good_list;

    /**
     * 菜单名
     **/
    private  String name;
}
