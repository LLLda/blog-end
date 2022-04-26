package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Collect;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CollectMapper extends BaseMapper<Collect> {
    List<Collect> getCollectAll(@Param("topicIds") List<Integer> topicIds);
}
