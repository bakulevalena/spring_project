package com.example.homework.service;

import com.example.homework.dto.MessageDTO;

import java.time.LocalDateTime;

public interface PayloadService {
    String processMessage(MessageDTO message);

    MessageDTO getMessage();

    LocalDateTime getData();
}
