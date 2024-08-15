package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class AskService {

    public String getAnswer(String question) {
        return "This is a placeholder answer for: " + question;
    }
}

