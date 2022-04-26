package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
// menu_id——菜单id
// menu_name——菜单名
// menu_content——菜单介绍
// menu_status——菜单状态（0-已删除 1-存在）
// user_id——所属用户id
@TableName("bc_menu")
public class Menu {

    @TableId(value = "menu_id", type = IdType.AUTO)
    private Integer menu_id;

    @TableField("menu_name")
    private String menu_name;

//    @TableField("menu_content")
//    private String menu_content;

    @TableField("menu_status")
    private Integer menu_status;

    @TableField("user_id")
    private Integer user_id;
}
