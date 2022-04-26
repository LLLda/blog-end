package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
// menu_id——菜单id
// menu_name——菜单名
// menu_content——菜单介绍
// menu_status——菜单状态（0-已删除 1-存在）
// user_id——所属用户id
@TableName("bc_dishes")
public class Dishes {
    private Integer dishes_id;
    private String dishes_name;
    private String dishes_content;
    private Integer dishes_status;
    private Float dishes_price;
    private Integer menu_id;
    private String dishes_imgUrl;
}