package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.Collect;
import com.example.demo.entity.Comment;
import com.example.demo.entity.Like;
import com.example.demo.entity.Topic;
import com.example.demo.interfaces.CollectInterface;
import com.example.demo.mapper.CollectMapper;
import com.example.demo.mapper.TopicMapper;
import com.example.demo.vo.CollectTopicVO;
import com.example.demo.vo.CommentTopicVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CollectService implements CollectInterface {
    @Autowired
    CollectMapper collectMapper;

    @Autowired
    TopicMapper topicMapper;

    @Override
    public String addCollect(Integer userCId,Integer topicId){
        Collect collect = new Collect();
        collect.setTopic_id(topicId);
        collect.setUserC_id(userCId);
        collectMapper.insert(collect);
        return "success";
    }


    @Override
    public String delCollect(Integer userCId,Integer topicId){
        Collect collect = new Collect();
        collect.setTopic_id(topicId);
        collect.setUserC_id(userCId);
        QueryWrapper<Collect> queryWrapper = new QueryWrapper<>(collect);
        Integer result = collectMapper.delete(queryWrapper);
        if(result==0){
            return "success";
        }else{
            return "fail";
        }
    }

    @Override
    public List<CollectTopicVO> getCollectRecord(Integer userCId){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("distinct userC_id,topic_id");
        queryWrapper.eq("userC_id",userCId);
        List<Collect> collectList = collectMapper.selectList(queryWrapper);

        //归集
        List<Integer> topicIds = collectList.stream().map(Collect::getTopic_id).collect(Collectors.toList());

        List<CollectTopicVO> collectTopicVOS = new ArrayList<>();

        if(topicIds.size()<1 || topicIds==null){
            return collectTopicVOS;
        }

        List<Topic> topics = topicMapper.getTopic(topicIds);

        Map<Integer,List<Topic>> topicMap = topics.stream().collect(Collectors.groupingBy(Topic::getTopic_id));



        collectList.stream().forEach(item->{
            CollectTopicVO collectTopicVO = new CollectTopicVO();
            List<Topic> topicList = topicMap.get(item.getTopic_id());
            collectTopicVO.setCollectId(null);
            collectTopicVO.setTopics(topicList);
            collectTopicVOS.add(collectTopicVO);
        });
        return collectTopicVOS;
    }

    @Override
    public String checkCollect(Integer userCId,Integer topicId){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("userC_id",userCId);
        queryWrapper.eq("topic_id",topicId);
        List<Collect> collectList = collectMapper.selectList(queryWrapper);
        if(collectList!=null && collectList.size()>0){
            return "true";
        }else {
            return "false";
        }
    }

}
