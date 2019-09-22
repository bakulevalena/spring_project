package com.example.homework.service;

import org.springframework.stereotype.Service;

@Service
public class MessageProcessing implements PayloadService{

    String savedMessage;

    @Override
    public void processMessage(String message) {
        this.savedMessage=message;
    }

    @Override
    public String returnMessage() {
        return this.savedMessage;
    }
}
