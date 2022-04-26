package com.example.demo.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.*;
import com.example.demo.interfaces.TopicInterface;
import com.example.demo.mapper.*;
import com.example.demo.vo.TopicsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TopicService implements TopicInterface {

    @Autowired
    private TopicMapper topicMapper;

    @Autowired
    private UserCMapper userCMapper;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private CollectMapper collectMapper;

    @Autowired
    private LikeMapper likeMapper;

    @Override
    public List<TopicsVo> getTopicAll(){
        //查询所有帖子信息
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("topic_status",1);
        queryWrapper.orderByDesc("topic_id");
        List<Topic> topicList = topicMapper.selectList(queryWrapper);

        //归集帖子ids
        List<Integer> topicIds = topicList.stream().map(Topic::getTopic_id).collect(Collectors.toList());

        // 归集帖子对应用户ids
        List<Integer> userCIds = topicList.stream().map(Topic::getUserC_id).collect(Collectors.toList());

        //根据帖子ids查询所有评论
        List<Comment> commentList = commentMapper.commentCount(topicIds);

        //根据帖子ids查询所有收藏记录
        List<Collect> collectList = collectMapper.getCollectAll(topicIds);

        //根据帖子ids查询所有点餐记录
        List<Like> likeList = likeMapper.getLikeAll(topicIds);

        //根据用户ids查询用户信息
        List<UserC> userCS = userCMapper.getUserCById(userCIds);

        // 将帖子list变成一个Map<帖子的id, 对应的评论list>
        Map<Integer,List<Comment>> collect = commentList.stream().collect(Collectors.groupingBy(Comment::getTopic_id));

        // <帖子id，对应帖子>
        Map<Integer,List<Topic>> collect1 = topicList.stream().collect(Collectors.groupingBy(Topic::getTopic_id));

        // <用户id，对应用户>
        Map<Integer,List<UserC>> collect2 = userCS.stream().collect(Collectors.groupingBy(UserC::getUserC_Id));

        // <帖子id，收藏list>
        Map<Integer,List<Collect>> collect3 = collectList.stream().collect(Collectors.groupingBy(Collect::getTopic_id));

        // <帖子id，点赞list>
        Map<Integer,List<Like>> collect4 = likeList.stream().collect(Collectors.groupingBy(Like::getTopic_id));

        // 结果集
        List<TopicsVo> topicsVoList = new ArrayList<>();

        //遍历插入数据
        topicList.stream().forEach(item->{
            TopicsVo topicsVo = new TopicsVo();
            List<Like> likes = collect4.get(item.getTopic_id());
            if(likes!=null){
                topicsVo.setLikes(likes.size());
            }else{
                topicsVo.setLikes(0);
            }
            List<Collect> collects = collect3.get(item.getTopic_id());
            if(collects!=null){
                topicsVo.setCollects(collects.size());
            }else{
                topicsVo.setCollects(0);
            }
            List<UserC> userCS1 = collect2.get(item.getUserC_id());
            topicsVo.setUserCS(userCS1);
            List<Topic> topics = collect1.get(item.getTopic_id());
            topicsVo.setTopics(topics);
            List<Comment> comment = collect.get(item.getTopic_id());
            if(comment != null){
                topicsVo.setComments(comment.size());
            }else {
                topicsVo.setComments(0);
            }
            topicsVoList.add(topicsVo);
        });
        return topicsVoList;
    }

    @Override
    public List<TopicsVo> getTopicByClassify(Integer classifyId){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("classify_id",classifyId);
        List<Topic> topicList = topicMapper.selectList(queryWrapper);
        //归集帖子ids
        List<Integer> topicIds = topicList.stream().map(Topic::getTopic_id).collect(Collectors.toList());

        if(topicIds.size() <= 0){
            List<TopicsVo> topicsVoList = new ArrayList<>();
            return topicsVoList;
        }
        // 归集帖子对应用户ids
        List<Integer> userCIds = topicList.stream().map(Topic::getUserC_id).collect(Collectors.toList());

        //根据帖子ids查询所有评论
        List<Comment> commentList = commentMapper.commentCount(topicIds);

        //根据帖子ids查询所有收藏记录
        List<Collect> collectList = collectMapper.getCollectAll(topicIds);

        //根据帖子ids查询所有点餐记录
        List<Like> likeList = likeMapper.getLikeAll(topicIds);

        //根据用户ids查询用户信息
        List<UserC> userCS = userCMapper.getUserCById(userCIds);

        // 将帖子list变成一个Map<帖子的id, 对应的评论list>
        Map<Integer,List<Comment>> collect = commentList.stream().collect(Collectors.groupingBy(Comment::getTopic_id));

        // <帖子id，对应帖子>
        Map<Integer,List<Topic>> collect1 = topicList.stream().collect(Collectors.groupingBy(Topic::getTopic_id));

        // <用户id，对应用户>
        Map<Integer,List<UserC>> collect2 = userCS.stream().collect(Collectors.groupingBy(UserC::getUserC_Id));

        // <帖子id，收藏list>
        Map<Integer,List<Collect>> collect3 = collectList.stream().collect(Collectors.groupingBy(Collect::getTopic_id));

        // <帖子id，点赞list>
        Map<Integer,List<Like>> collect4 = likeList.stream().collect(Collectors.groupingBy(Like::getTopic_id));

        // 结果集
        List<TopicsVo> topicsVoList = new ArrayList<>();

        //遍历插入数据
        topicList.stream().forEach(item->{
            TopicsVo topicsVo = new TopicsVo();
            List<Like> likes = collect4.get(item.getTopic_id());
            if(likes!=null){
                topicsVo.setLikes(likes.size());
            }else{
                topicsVo.setLikes(0);
            }
            List<Collect> collects = collect3.get(item.getTopic_id());
            if(collects!=null){
                topicsVo.setCollects(collects.size());
            }else{
                topicsVo.setCollects(0);
            }
            List<UserC> userCS1 = collect2.get(item.getUserC_id());
            topicsVo.setUserCS(userCS1);
            List<Topic> topics = collect1.get(item.getTopic_id());
            topicsVo.setTopics(topics);
            List<Comment> comment = collect.get(item.getTopic_id());
            if(comment != null){
                topicsVo.setComments(comment.size());
            }else {
                topicsVo.setComments(0);
            }
            topicsVoList.add(topicsVo);
        });
        return topicsVoList;
    }

    @Override
    public List<Topic> getTopicById(Integer topicId){
        QueryWrapper<Topic> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("topic_id",topicId);
        List<Topic> topics = topicMapper.selectList(queryWrapper);
        return topics;
    }

    @Override
    public String addTopic(String topicContent, Long topicTime, Integer userCId,Integer classifyId,String imgUrl){
        Topic topic = new Topic();
        topic.setTopic_content(topicContent);
        topic.setTopic_time(topicTime);
        topic.setClassify_id(classifyId);
        topic.setUserC_id(userCId);
        topic.setTopic_imgUrl(imgUrl);
        topicMapper.insert(topic);
        return "success";
    }
}
