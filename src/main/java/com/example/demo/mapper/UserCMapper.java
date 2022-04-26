package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.UserC;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserCMapper extends BaseMapper<UserC> {
    List<UserC> getUserCById(@Param("userCIds") List<Integer> userCIds);
}
