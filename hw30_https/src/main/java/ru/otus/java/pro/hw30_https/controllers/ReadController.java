package ru.otus.java.pro.hw30_https.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.otus.java.pro.hw30_https.dtos.MessageDto;
import ru.otus.java.pro.hw30_https.dtos.SimplestPageDto;
import ru.otus.java.pro.hw30_https.services.MessageService;

@RestController
@RequestMapping("/api/v1/read")
public class ReadController {
    private final MessageService messageService;
    @Autowired
    public ReadController(MessageService messageService) {
        this.messageService = messageService;
    }
    @GetMapping
    public SimplestPageDto<MessageDto> findAllMessages () {
        return new SimplestPageDto<>(messageService.findAllMessages());
    }
}
