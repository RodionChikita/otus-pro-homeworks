package ru.otus.java.pro.hw30_https.entites;



import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;
@Getter
@Setter
@Table("messages")
public class Message {
    @Id
    private Long id;
    private String textMessage;
    private Date createdAt;
    @PersistenceCreator
    public Message(Long id, String textMessage, Date createdAt) {
        this.id = id;
        this.textMessage = textMessage;
        this.createdAt =  createdAt;
    }
}
