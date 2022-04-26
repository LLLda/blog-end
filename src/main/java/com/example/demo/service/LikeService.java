package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.Like;
import com.example.demo.entity.Menu;
import com.example.demo.entity.Topic;
import com.example.demo.interfaces.LikeInterface;
import com.example.demo.mapper.LikeMapper;
import com.example.demo.mapper.TopicMapper;
import com.example.demo.vo.LikeTopicVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class LikeService implements LikeInterface {
    @Autowired
    private LikeMapper likeMapper;

    @Autowired
    private TopicMapper topicMapper;

    @Override
    public String addLike(Integer userCId,Integer topicId){
        Like like = new Like();
        like.setTopic_id(topicId);
        like.setUserC_id(userCId);
        likeMapper.insert(like);
        return "success";
    }

    @Override
    public String delLike(Integer userCId,Integer topicId){
        Like like = new Like();
        like.setUserC_id(userCId);
        like.setTopic_id(topicId);
        QueryWrapper<Like> likeQueryWrapper = new QueryWrapper<>(like);
        int result = likeMapper.delete(likeQueryWrapper);
        if(result==0){
            return "success";
        }else{
            return "fail";
        }
    }

    @Override
    public String checkLike(Integer userCId,Integer topicId){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("userC_id",userCId);
        queryWrapper.eq("topic_id",topicId);
        List<Like> likeList = likeMapper.selectList(queryWrapper);
        if(likeList!=null && likeList.size()>0){
            return "true";
        }else {
            return "false";
        }
    }

    @Override
    public List<LikeTopicVO> getLikeRecord(Integer userCId){
        QueryWrapper<Like> queryWrapper = new QueryWrapper();
        queryWrapper.select("distinct userC_id,topic_id");
        queryWrapper.eq("userC_id",userCId);
        List<Like> likeList = likeMapper.selectList(queryWrapper);


        //归集
        List<Integer> topicIds = likeList.stream().map(Like::getTopic_id).collect(Collectors.toList());

        List<LikeTopicVO> likeTopicVOS = new ArrayList<>();

        if(topicIds.size()<1 || topicIds==null){
            return likeTopicVOS;
        }

        //查询topicIds对应帖子
        List<Topic> topics = topicMapper.getTopic(topicIds);

        Map<Integer,List<Topic>> topicMap = topics.stream().collect(Collectors.groupingBy(Topic::getTopic_id));



        likeList.stream().forEach(item->{
            LikeTopicVO likeTopicVO = new LikeTopicVO();
            List<Topic> topicList = topicMap.get(item.getTopic_id());
            likeTopicVO.setLikeId(null);
            likeTopicVO.setTopics(topicList);
            likeTopicVOS.add(likeTopicVO);
        });
        return likeTopicVOS;
    }

}
