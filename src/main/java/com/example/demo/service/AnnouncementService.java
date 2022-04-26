package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.Announcement;
import com.example.demo.entity.UserC;
import com.example.demo.interfaces.AnnouncementInterface;
import com.example.demo.mapper.AnnouncementMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnouncementService implements AnnouncementInterface {
    @Autowired
    AnnouncementMapper announcementMapper;

    @Override
    public List<Announcement> getAnnouncement(){
        QueryWrapper queryWrapper =new QueryWrapper();
        queryWrapper.eq("announcement_status",1);
        List<Announcement> res =  announcementMapper.selectList(queryWrapper);
        return res;
    }

    @Override
    public String addAnnouncement(String announcementHeadline,String announcementContent,Long announcementTime){
        Announcement announcement = new Announcement();
        announcement.setAnnouncement_content(announcementContent);
        announcement.setAnnouncement_time(announcementTime);
        announcement.setAnnouncement_headline(announcementHeadline);
        announcementMapper.insert(announcement);
        return "success";
    }

}
