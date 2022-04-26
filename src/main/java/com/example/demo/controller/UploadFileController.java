package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadFileController {

    @Value("${upload.file.location}")
    private String location;

    @Value("${upload.file.display.url}")
    private String locationUrl;

    @PostMapping("/api/uploadFile")
    public String uploadFile(
            @Param("file") MultipartFile file
    ){
        try {
            if (file.isEmpty()) {

                log.warn("★上传的文件为空！★");
            } else {
                if (file.getSize() > 52428800) {

                    log.warn("★上传的文件超过50MB！★");
                } else {


                    String fileName = file.getOriginalFilename();  // 获取到的文件名
                    String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
                    String filePath = location; // 上传后的路径
                    fileName = UUID.randomUUID() + suffixName; // 随机生成的新文件名加上后缀名
                    File dest = new File(filePath + fileName);//dest是绝对路径
                    if (!dest.getParentFile().exists()) {//判断是否存在上级目录（/Upload/file/)
                        dest.getParentFile().mkdirs();//否则创建目录
                    }
                    try {
                        file.transferTo(dest);//将新的文件存入磁盘中
                        //存入数据库
                        return locationUrl + "/" + fileName;
                    } catch (IOException e) {
                        log.error("★操作出现异常！★");
                        e.printStackTrace();
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("★操作出现异常！★");
        }
        return "";
    }
}
