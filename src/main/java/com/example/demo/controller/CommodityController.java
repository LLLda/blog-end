package com.example.demo.controller;

import com.example.demo.entity.Commodity;
import com.example.demo.entity.CommodityRecord;
import com.example.demo.interfaces.CommodityInterface;
import com.example.demo.vo.CommodityUserVO;
import com.example.demo.vo.CommodityVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/commodity")
public class CommodityController {
    @Resource
    private CommodityInterface commodityInterface;

    @GetMapping("/getCommodity")
    public List<Commodity> getCommodity(){
        return commodityInterface.getCommodity();
    }

    @GetMapping("/getCommodityById")
    public List<Commodity> getCommodityById(@Param("id") Integer id){
        return commodityInterface.getCommodityById(id);
    }

    @GetMapping("/getCommodityRecord")
    public List<CommodityVO> getCommodityByUser(@Param("userCId") Integer userCId){
        return commodityInterface.getCommodityByUser(userCId);
    };

    @PostMapping("/addCommodityRecord")
    public String addCommodityRecord(@Param("userCID") Integer userCId,@Param("commodityId") Integer commodityId,@Param("commodityRecordTime") Long commodityRecordTime){
        return commodityInterface.addCommodityRecord(userCId,commodityId, commodityRecordTime);
    }

    @PostMapping("/addCommodity")
    public String addCommodity(@Param("commodityName") String commodityName,@Param("commodityDes") String commodityDes,@Param("commodityType") Integer commodityType,@Param("commodityIntegral") Integer commodityIntegral,@Param("commodityStock") Integer commodityStock,@Param("commodityUrl") String commodityUrl){
        return commodityInterface.addCommodity(commodityName,commodityDes,commodityType,commodityIntegral,commodityStock,commodityUrl);
    }
    @PostMapping("/editCommodity")
    public String editCommodity(@Param("commodityId") Integer commodityId,@Param("commodityName") String commodityName,@Param("commodityDes") String commodityDes,@Param("commodityType") Integer commodityType,@Param("commodityIntegral") Integer commodityIntegral,@Param("commodityStock") Integer commodityStock,@Param("commodityUrl") String commodityUrl ,@Param("commodityStatus") Integer commodityStatus){
        return commodityInterface.editCommodity(commodityId,commodityName,commodityDes,commodityType,commodityIntegral,commodityStock,commodityStatus,commodityUrl);
    }

    @GetMapping("/editCommodityRecord")
    public String editCommodityRecord(@Param("commodityRecordId") Integer commodityRecordId){
        return commodityInterface.editCommodityRecord(commodityRecordId);
    }

    @GetMapping("/getCommodityRecordByType")
    public List<CommodityUserVO> getCommodityRecord(@Param("type") Integer type){
        return commodityInterface.getCommodityRecord(type);
    }

}
