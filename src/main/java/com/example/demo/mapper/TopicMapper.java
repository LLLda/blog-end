package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Topic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TopicMapper extends BaseMapper<Topic> {
    List<Topic> getTopic(@Param("topicIds") List<Integer> topicIds);
}
