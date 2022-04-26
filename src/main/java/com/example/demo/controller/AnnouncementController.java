package com.example.demo.controller;

import com.example.demo.entity.Announcement;
import com.example.demo.interfaces.AnnouncementInterface;
import com.example.demo.mapper.AnnouncementMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/announcement")
public class AnnouncementController {
    @Resource
    private AnnouncementInterface announcementInterface;

    @GetMapping("/getList")
    public List<Announcement> getAnnouncement(){
        return announcementInterface.getAnnouncement();
    }

    @PostMapping("/addAnnouncement")
    public String addAnnouncement(@Param("announcementHeadline") String announcementHeadline,@Param("announcementContent") String announcementContent,@Param("announcementTime") Long announcementTime){
        return announcementInterface.addAnnouncement(announcementHeadline,announcementContent,announcementTime);
    }
}
