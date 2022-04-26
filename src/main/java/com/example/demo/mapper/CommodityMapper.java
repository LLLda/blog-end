package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Commodity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommodityMapper extends BaseMapper<Commodity> {
    List<Commodity> getCommodityAll(@Param("commodityIds") List<Integer> commodityIds);
}
