package ru.otus.java.pro.dataprocessor;

import ru.otus.java.pro.newStructure.SmsDataNewStructure;
import ru.otus.java.pro.oldStructure.SmsData;

public interface Processor {
    SmsDataNewStructure process(SmsData data);
}
