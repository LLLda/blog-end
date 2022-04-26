package com.example.demo.vo;

import com.example.demo.entity.Commodity;
import com.example.demo.entity.UserC;
import lombok.Data;

import java.util.List;

@Data
public class CommodityUserVO {
    private Integer commodityRecord_id;
    private Integer commodityRecord_status;
    private Long commodityRecord_time;
    private List<UserC> userCList;
    private List<Commodity> commodityList;
}
