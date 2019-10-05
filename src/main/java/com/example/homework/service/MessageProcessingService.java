package com.example.homework.service;

import com.example.homework.dto.MessageDTO;
import com.example.homework.entity.Message;
import com.example.homework.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageProcessingService implements PayloadService {

    private MessageRepository messageRepository;

    public MessageProcessingService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public String processMessage(MessageDTO message) {
        Message savedMessage = new Message();
        savedMessage.setMessage(message.getMessage());
        savedMessage.setCreationDate(LocalDateTime.now());
        messageRepository.save(savedMessage);
        return "Saved";
    }

    @Override
    public List<MessageDTO> getAllMessages() {
        List<Message> allMessages = messageRepository.findAll();
        List<MessageDTO> resultList = new ArrayList<>(allMessages.size());
        for (Message message : allMessages) {
            MessageDTO temp = new MessageDTO();
            temp.setMessage(message.getMessage());
            resultList.add(temp);
        }
        return resultList;
    }

    @Override
    public MessageDTO getMessage() {
        MessageDTO messageDTO = new MessageDTO();
        Message lastMessage = messageRepository.findFirstByMessageIsNotNullOrderByCreationDateDesc();
        if (lastMessage != null) {
            messageDTO.setMessage(lastMessage.getMessage());
        } else {
            return null;
        }
        return messageDTO;
    }

    @Override
    public LocalDateTime getData() {
        return LocalDateTime.now();
    }
}
