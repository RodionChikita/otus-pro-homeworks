package ru.otus.java.pro;


import org.json.simple.parser.ParseException;
import ru.otus.java.pro.dataprocessor.*;
import ru.otus.java.pro.newstructure.SmsDataNewStructure;
import ru.otus.java.pro.oldstructure.SmsData;

import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;

public class Demo {
    public static void main(String[] args) {
        Logger log = Logger.getLogger(Demo.class.getName());
        Deserializer deserializer = new FileDeserializer();
        Serializer serializer = new FileSerializer();
        Processor processor = new ProcessorAggregator();
        try (FileReader fileReader = new FileReader("sms.json")) {
            SmsData smsData = deserializer.data(fileReader);
            SmsDataNewStructure smsDataNewStructure = processor.process(smsData);
            log.info(smsDataNewStructure.toString());
            serializer.serialize(smsDataNewStructure);

        } catch (IOException | ParseException exception) {
            log.info(exception.getMessage());
        }
    }
}