package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_userB")
public class UserB {
    private Integer userB_id;
    private String userB_name;
    private String userB_pwd;
}
