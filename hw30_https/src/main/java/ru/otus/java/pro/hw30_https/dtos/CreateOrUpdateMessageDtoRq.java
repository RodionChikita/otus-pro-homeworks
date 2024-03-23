package ru.otus.java.pro.hw30_https.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrUpdateMessageDtoRq {
    private Long id;
    private String textMessage;
    private Date createdAt;
}
