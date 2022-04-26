package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Like;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LikeMapper extends BaseMapper<Like> {
    List<Like> getLikeAll(@Param("topicIds") List<Integer> topicIds);
}
