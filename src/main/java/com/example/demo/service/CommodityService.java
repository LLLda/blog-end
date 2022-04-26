package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.demo.entity.*;
import com.example.demo.interfaces.CommodityInterface;
import com.example.demo.mapper.CommodityMapper;
import com.example.demo.mapper.CommodityRecordMapper;
import com.example.demo.mapper.UserCMapper;
import com.example.demo.vo.CommodityUserVO;
import com.example.demo.vo.CommodityVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

@Service
public class CommodityService implements CommodityInterface {
    @Autowired
    private CommodityMapper commodityMapper;

    @Autowired
    private CommodityRecordMapper commodityRecordMapper;

    @Autowired
    private UserCMapper userCMapper;

    @Override
    public List<Commodity> getCommodity(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("commodity_status",1);
        List<Commodity> commodityList = commodityMapper.selectList(queryWrapper);
        return commodityList;
    }
    @Override
    public List<Commodity> getCommodityById(Integer id){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("commodity_id",id);
        List<Commodity> commodityList = commodityMapper.selectList(queryWrapper);
        return commodityList;
    }

    @Override
    public List<CommodityVO> getCommodityByUser(Integer userCId){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("userC_id",userCId);
        List<CommodityRecord> commodityRecordList = commodityRecordMapper.selectList(queryWrapper);

        List<Integer> recordIds = commodityRecordList.stream().map(CommodityRecord::getCommodityRecord_id).collect(Collectors.toList());
        List<Commodity> commodityList;
        Map<Integer,List<Commodity>> collect;
        if (recordIds.size()>0){
            commodityList = commodityMapper.getCommodityAll(recordIds);
            collect = commodityList.stream().collect(Collectors.groupingBy(Commodity::getCommodity_id));
        } else {
            collect = null;
        }


        List<CommodityVO> commodityVOS = new ArrayList<>();

        commodityRecordList.stream().forEach(item->{
            CommodityVO commodityVO = new CommodityVO();

            if(collect!=null){
                List<Commodity> commodityList1 = collect.get(item.getCommodity_id());
                commodityVO.setCommodityList(commodityList1);
            } else {
                commodityVO.setCommodityList(null);
            }
            commodityVO.setCommodityRecordStatus(item.getCommodityRecord_status());
            commodityVO.setCommodityRecordId(item.getCommodity_id());
            commodityVO.setCommodityRecordTime(item.getCommodityRecord_time());
            commodityVOS.add(commodityVO);
        });
        return commodityVOS;
    }

    @Override
    public String addCommodityRecord(Integer userCId,Integer commodityId, Long commodityRecordTime){
        CommodityRecord commodityRecord = new CommodityRecord();
        commodityRecord.setCommodity_id(commodityId);
        commodityRecord.setUserC_id(userCId);
        commodityRecord.setCommodityRecord_time(commodityRecordTime);
        commodityRecordMapper.insert(commodityRecord);
        return "success";
    }

    @Override
    public String addCommodity(String commodityName,String commodityDes, Integer commodityType,Integer commodityIntegral,Integer commodityStock,String commodityUrl){
        Commodity commodity = new Commodity();
        commodity.setCommodity_des(commodityDes);
        commodity.setCommodity_integral(commodityIntegral);
        commodity.setCommodity_stock(commodityStock);
        commodity.setCommodity_name(commodityName);
        commodity.setCommodity_type(commodityType);
        commodity.setCommodity_img(commodityUrl);
        commodityMapper.insert(commodity);
        return "success";
    }

    @Override
    public String editCommodity(Integer commodityId, String commodityName,String commodityDes, Integer commodityType,Integer commodityIntegral,Integer commodityStock,Integer commodityStatus,String commodityUrl){
        UpdateWrapper<Commodity> updateWrapper = new UpdateWrapper<>();
        Commodity commodity = new Commodity();
        updateWrapper.eq("commodity_id",commodityId).set("commodity_name",commodityName).set("commodity_des",commodityDes).set("commodity_type",commodityType).set("commodity_integral",commodityIntegral).set("commodity_stock",commodityStock).set("commodity_status",commodityStatus).set("commodity_img",commodityUrl);
        commodityMapper.update(commodity,updateWrapper);
        return "success";
    }

    @Override
    public String editCommodityRecord(Integer commodityRecordId){
        UpdateWrapper<CommodityRecord> updateWrapper = new UpdateWrapper<>();
        CommodityRecord commodityRecord = new CommodityRecord();
        updateWrapper.eq("commodityRecord_id",commodityRecordId).set("commodityRecord_status",0);
        commodityRecordMapper.update(commodityRecord,updateWrapper);
        return "success";
    }

    @Override
    public List<CommodityUserVO> getCommodityRecord(Integer type){
        QueryWrapper<CommodityRecord> queryWrapper = new QueryWrapper<>();
        if(type == 0){
            queryWrapper.eq("commodityRecord_status",0);
        }else if(type == 1){
            queryWrapper.eq("commodityRecord_status",1);
        }
        List<CommodityRecord> commodityRecordList = commodityRecordMapper.selectList(queryWrapper);

        // 归集用户id
        List<Integer> userIds = commodityRecordList.stream().map(CommodityRecord::getUserC_id).collect(Collectors.toList());
        // 归集商品id
        List<Integer> commodityIds = commodityRecordList.stream().map(CommodityRecord::getCommodity_id).collect(Collectors.toList());
        // 根据用户ids查询所有用户信息
        List<UserC> userCS = userCMapper.getUserCById(userIds);
        // 根据商品ids查询所有商品信息
        List<Commodity> commodities = commodityMapper.getCommodityAll(commodityIds);

       Map<Integer,List<UserC>> collect = userCS.stream().collect(Collectors.groupingBy(UserC::getUserC_Id));
        Map<Integer,List<Commodity>> collect1 = commodities.stream().collect(Collectors.groupingBy(Commodity::getCommodity_id));

        List<CommodityUserVO> commodityUserVO = new ArrayList<>();
        commodityRecordList.stream().forEach(item->{
            CommodityUserVO commodityUserVO1 = new CommodityUserVO();
            List<UserC> userCS1 = collect.get(item.getUserC_id());
            List<Commodity> commodities1 = collect1.get(item.getCommodity_id());
            commodityUserVO1.setUserCList(userCS1);
            commodityUserVO1.setCommodityList(commodities1);
            commodityUserVO1.setCommodityRecord_id(item.getCommodityRecord_id());
            commodityUserVO1.setCommodityRecord_time(item.getCommodityRecord_time());
            commodityUserVO1.setCommodityRecord_status(item.getCommodityRecord_status());
            commodityUserVO.add(commodityUserVO1);
        });
        return commodityUserVO;
    }
}
