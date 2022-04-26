package com.example.demo.interfaces;

import com.example.demo.entity.Commodity;
import com.example.demo.entity.CommodityRecord;
import com.example.demo.vo.CommodityUserVO;
import com.example.demo.vo.CommodityVO;

import java.util.List;

public interface CommodityInterface {
    List<Commodity> getCommodity();
    List<Commodity> getCommodityById(Integer id);
    List<CommodityVO> getCommodityByUser(Integer userCId);
    String addCommodityRecord(Integer userCId,Integer commodityId, Long commodityRecordTime);
    String editCommodityRecord(Integer commodityRecordId);
    String editCommodity(Integer commodityId, String commodityName,String commodityDes, Integer commodityType,Integer commodityIntegral,Integer commodityStock,Integer commodityStatus,String commodityUrl);
    String addCommodity(String commodityName,String commodityDes, Integer commodityType,Integer commodityIntegral,Integer commodityStock,String commodityUrl);
    List<CommodityUserVO> getCommodityRecord(Integer type);
}
