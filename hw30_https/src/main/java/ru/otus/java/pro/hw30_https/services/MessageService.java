package ru.otus.java.pro.hw30_https.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.java.pro.hw30_https.dtos.MessageDto;
import ru.otus.java.pro.hw30_https.entites.Message;
import ru.otus.java.pro.hw30_https.repositories.MessageRepository;


import java.util.Date;
import java.util.List;

@Service
public class MessageService {
    private final MessageRepository messageRepository;
    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }
    @PreAuthorize("hasAuthority('READER') || hasAuthority('WRITER')")
    public List<MessageDto> findAllMessages() {
        return messageRepository.findAllMessages();
    }
    @Transactional
    public void createNewMessage(String textMessage) {
        Message newMessage = new Message(null, textMessage, new Date());
        messageRepository.save(newMessage);
    }
}
