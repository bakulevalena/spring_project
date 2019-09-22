package com.example.homework.controller;

import com.example.homework.service.PayloadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;

@RestController
public class OurController {

    private PayloadService payloadService;

    Date date = new Date();

    public OurController(PayloadService payloadService) {
        this.payloadService = payloadService;
    }

    @RequestMapping(value = "/api/time", method = RequestMethod.GET)
    public String getData() {
        return date.toString();
    }

    @RequestMapping(value = "/api/data", method = RequestMethod.GET)
    public ResponseEntity getMessage() {
        return ResponseEntity.ok(payloadService.returnMessage());
    }

    @RequestMapping(value = "/api/data", method = RequestMethod.POST)
    public ResponseEntity saveMessage(@RequestBody String body) {
        payloadService.processMessage(body);
        return ResponseEntity.ok("Saved");
    }

}
