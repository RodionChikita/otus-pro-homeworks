package ru.otus.java.pro;


import org.json.simple.parser.ParseException;
import ru.otus.java.pro.dataprocessor.*;
import ru.otus.java.pro.newStructure.SmsDataNewStructure;
import ru.otus.java.pro.oldStructure.SmsData;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Demo {
    public static void main(String args[]) {
        Deserializer deserializer = new FileDeserializer();
        Serializer serializer = new FileSerializer();
        Processor processor = new ProcessorAggregator();
        try (FileReader fileReader = new FileReader("/Users/rodioncikita/Downloads/sms.json")) {
            SmsData smsData = deserializer.data(fileReader);
            SmsDataNewStructure smsDataNewStructure = processor.process(smsData);
            System.out.println(smsDataNewStructure);
            serializer.serialize(smsDataNewStructure);

        } catch (IOException | ParseException exception) {
            exception.printStackTrace();
        }
    }
}