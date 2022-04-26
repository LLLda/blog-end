package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("b_user")
public class User {
    private Integer user_id;
    private String user_name;
    private String user_password;
    private Integer regist_id;
    private Integer user_status;
    private String user_address;
    private String store_name;
}
