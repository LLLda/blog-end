package com.example.demo.interfaces;

import com.example.demo.entity.Announcement;

import java.util.List;

public interface AnnouncementInterface {
//    获取公告列表
    List<Announcement> getAnnouncement();
    String addAnnouncement(String announcementHeadline,String announcementContent,Long announcementTime);
}
