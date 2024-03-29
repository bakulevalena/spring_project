package com.example.homework.repository;

import com.example.homework.entity.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {
    Message findFirstByMessageIsNotNullOrderByCreationDateDesc();
    List<Message> findAll();
}
