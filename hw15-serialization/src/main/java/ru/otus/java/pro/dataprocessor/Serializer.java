package ru.otus.java.pro.dataprocessor;

import ru.otus.java.pro.newStructure.MessageAggregatedByBelongNumber;
import ru.otus.java.pro.newStructure.SmsDataNewStructure;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface Serializer {
     void serialize(SmsDataNewStructure data) throws IOException;
}
