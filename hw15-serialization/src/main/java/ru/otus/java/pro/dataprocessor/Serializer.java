package ru.otus.java.pro.dataprocessor;

import ru.otus.java.pro.newstructure.SmsDataNewStructure;

import java.io.IOException;

public interface Serializer {
    void serialize(SmsDataNewStructure data) throws IOException;
}
