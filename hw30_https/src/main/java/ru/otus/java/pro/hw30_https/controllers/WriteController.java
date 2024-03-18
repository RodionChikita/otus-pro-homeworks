package ru.otus.java.pro.hw30_https.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.otus.java.pro.hw30_https.services.MessageService;

@RestController
@RequestMapping("/api/v1/write")
public class WriteController {
    private final MessageService messageService;
    @Autowired
    public WriteController(MessageService messageService) {
        this.messageService = messageService;
    }
    @GetMapping
    public void createNewMessage(@RequestParam(required = false, name = "a") String textMessage) {
        messageService.createNewMessage(textMessage);
    }

}
