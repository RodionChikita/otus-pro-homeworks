package ru.otus.java.pro.dataprocessor;

import ru.otus.java.pro.newstructure.SmsDataNewStructure;
import ru.otus.java.pro.oldstructure.SmsData;

public interface Processor {
    SmsDataNewStructure process(SmsData data);
}
