package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class FileUploadConfig  extends WebMvcConfigurerAdapter {
    @Value("${upload.file.location}")
    private String fileUploadLocation;
    @Value("${upload.file.display.location}")
    private String fileDisplayLocation;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
        registry.addResourceHandler(fileDisplayLocation).addResourceLocations("file:" + fileUploadLocation);
    }
}