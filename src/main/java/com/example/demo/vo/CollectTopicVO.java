package com.example.demo.vo;

import com.example.demo.entity.Topic;
import lombok.Data;

import java.util.List;

@Data
public class CollectTopicVO {
    private Integer collectId;
    private List<Topic> topics;
}
