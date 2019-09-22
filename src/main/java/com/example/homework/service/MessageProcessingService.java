package com.example.homework.service;

import com.example.homework.dto.MessageDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MessageProcessingService implements PayloadService {

    private String savedMessage;

    @Override
    public String processMessage(MessageDTO message) {
        this.savedMessage = message.getMessage();
        return "Saved";
    }

    @Override
    public MessageDTO getMessage() {
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setMessage(savedMessage);
        return messageDTO;
    }

    @Override
    public LocalDateTime getData() {
        return LocalDateTime.now();
    }
}
