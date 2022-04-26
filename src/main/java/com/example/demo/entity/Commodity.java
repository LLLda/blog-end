package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_commodity")
public class Commodity {
    private Integer commodity_id;
    private String commodity_name;
    private String commodity_des;
    private Integer commodity_type;
    private Integer commodity_integral;
    private Integer commodity_stock;
    private Integer commodity_status;
    private String commodity_img;
}
