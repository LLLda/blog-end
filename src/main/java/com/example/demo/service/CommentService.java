package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.*;
import com.example.demo.interfaces.CommentInterface;
import com.example.demo.mapper.CommentMapper;
import com.example.demo.mapper.TopicMapper;
import com.example.demo.mapper.UserCMapper;
import com.example.demo.vo.CommentTopicVO;
import com.example.demo.vo.CommentsVo;
import com.example.demo.vo.LikeTopicVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CommentService implements CommentInterface {
    @Autowired
    CommentMapper commentMapper;

    @Autowired
    UserCMapper userCMapper;

    @Autowired
    TopicMapper topicMapper;

    @Override
    //查询评论全部信息
    public List<CommentsVo> getCommentsAll(Integer topicId){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("topic_id",topicId);
        queryWrapper.orderByDesc("comment_id");
        List<Comment> comments = commentMapper.selectList(queryWrapper);

        //新建结果集
        List<CommentsVo> commentsVoList = new ArrayList<>();

        if(comments.size()==0){
            return commentsVoList;
        }

        // 归集评论ids
        List<Integer> commentsIds = comments.stream().map(Comment::getComment_id).collect(Collectors.toList());

        // 归集用户ids
        List<Integer> userCIds = comments.stream().map(Comment::getUserC_id).collect(Collectors.toList());

        // 根据用户ids查询用户信息
        List<UserC> userCS = userCMapper.getUserCById(userCIds);

        // <commentId,UserCs>
        Map<Integer,List<UserC>> collect = userCS.stream().collect(Collectors.groupingBy(UserC::getUserC_Id));

        /// <commentId,commentList>
        Map<Integer,List<Comment>> collect1 = comments.stream().collect(Collectors.groupingBy(Comment::getComment_id));



        // 循环加入数据
        comments.stream().forEach(item->{
            CommentsVo commentsVo = new CommentsVo();
            List<UserC> userCList = collect.get(item.getUserC_id());
            commentsVo.setUserCS(userCList);
            List<Comment> commentList = collect1.get(item.getComment_id());
            commentsVo.setComments(commentList);
            commentsVoList.add(commentsVo);
        });
        return commentsVoList;
    }

    @Override
    //上传评论
    public String addComments(Integer userCId, Integer topicId,String commentContent,Long commentTime){
            Comment comment = new Comment();
            comment.setComment_content(commentContent);
            comment.setComment_time(commentTime);
            comment.setTopic_id(topicId);
            comment.setUserC_id(userCId);
            commentMapper.insert(comment);
            return "success";
    }

    @Override
    public List<CommentTopicVO> getCommentRecord(Integer userCId){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("userC_id",userCId);
        queryWrapper.orderByDesc("comment_id");
        List<Comment> commentList = commentMapper.selectList(queryWrapper);

        //归集
        List<Integer> topicIds = commentList.stream().map(Comment::getTopic_id).collect(Collectors.toList());

        List<CommentTopicVO> commentTopicVOS = new ArrayList<>();

        if(topicIds.size()<1 || topicIds == null){
            return commentTopicVOS;
        }

        List<Topic> topics = topicMapper.getTopic(topicIds);

        Map<Integer,List<Topic>> topicMap = topics.stream().collect(Collectors.groupingBy(Topic::getTopic_id));



        commentList.stream().forEach(item->{
            CommentTopicVO commentTopicVO = new CommentTopicVO();
            List<Topic> topicList = topicMap.get(item.getTopic_id());
            commentTopicVO.setCommentId(item.getComment_id());
            commentTopicVO.setCommentContent(item.getComment_content());
            commentTopicVO.setTopics(topicList);
            commentTopicVOS.add(commentTopicVO);
        });
        return commentTopicVOS;
    }
}
