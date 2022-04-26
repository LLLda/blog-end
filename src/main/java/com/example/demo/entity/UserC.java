package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_userC")
public class UserC {
    private Integer userC_Id;
    private String userC_logName;
    private String userC_pwd;
    private String userC_name;
    private String userC_title;
    private Integer userC_integral;
    private Integer userC_age;
    private Integer userC_sex;
    private String userC_realName;
    private Long userC_realNumber;
    private Integer userC_realStatus;
    private Integer userC_status;
    private String userC_imgUrl;
}
