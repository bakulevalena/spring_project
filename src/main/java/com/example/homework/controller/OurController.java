package com.example.homework.controller;

import com.example.homework.dto.MessageDTO;
import com.example.homework.service.PayloadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OurController {

    private PayloadService payloadService;

    public OurController(PayloadService payloadService) {
        this.payloadService = payloadService;
    }

    @RequestMapping(value = "/api/time", method = RequestMethod.GET)
    public ResponseEntity getData() {
        return ResponseEntity.ok(payloadService.getData());
    }

    @RequestMapping(value = "/api/data", method = RequestMethod.GET)
    public ResponseEntity getMessage() {
        return ResponseEntity.ok(payloadService.getMessage());
    }

    @RequestMapping(value = "/api/data", method = RequestMethod.POST)
    public ResponseEntity saveMessage(@RequestBody MessageDTO body) {
        return ResponseEntity.ok(payloadService.processMessage(body));
    }

}
