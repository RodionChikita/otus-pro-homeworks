package ru.otus.java.pro.dataprocessor;

import ru.otus.java.pro.newStructure.SmsDataNewStructure;

import java.io.IOException;

public interface Serializer {
    void serialize(SmsDataNewStructure data) throws IOException;
}
