package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_commodityRecord")
public class CommodityRecord {
    private Integer commodityRecord_id;
    private Integer userC_id;
    private Integer commodity_id;
    private Long commodityRecord_time;
    private Integer commodityRecord_status;
}
