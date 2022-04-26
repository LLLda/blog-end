package com.example.demo.vo;

import com.example.demo.entity.Commodity;
import lombok.Data;

import java.util.List;

@Data
public class CommodityVO {
    private Integer commodityRecordId;
    private Long commodityRecordTime;
    private Integer commodityRecordStatus;
    private List<Commodity> commodityList;
}
