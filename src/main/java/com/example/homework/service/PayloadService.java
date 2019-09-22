package com.example.homework.service;

import com.example.homework.dto.MessageDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface PayloadService {
    String processMessage(MessageDTO message);

    MessageDTO getMessage();

    LocalDateTime getData();

    List<MessageDTO> getAllMessages();
}
