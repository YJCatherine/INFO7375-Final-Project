package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class RecommendService {

    public String getRecommendations(String topic) {
        // 这里你可以集成你的逻辑，例如调用Pinecone或其他服务
        return "These are placeholder recommendations for: " + topic;
    }
}

