package ru.otus.java.pro.hw30_https.repositories;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import ru.otus.java.pro.hw30_https.dtos.MessageDto;
import ru.otus.java.pro.hw30_https.entites.Message;

import java.util.List;

@Repository
public interface MessageRepository extends ListCrudRepository<Message, Long> {
    @Query(
            "select m.id, m.text_message, m.created_at from MESSAGES m"
    )
    List<MessageDto> findAllMessages();
}
