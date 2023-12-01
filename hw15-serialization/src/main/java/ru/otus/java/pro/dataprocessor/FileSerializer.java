package ru.otus.java.pro.dataprocessor;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.otus.java.pro.Demo;
import ru.otus.java.pro.newstructure.SmsDataNewStructure;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;

public class FileSerializer implements Serializer {
    @Override
    public void serialize(SmsDataNewStructure data) throws IOException {
        Logger log = Logger.getLogger(FileSerializer.class.getName());
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(data);
        log.info(json);
        try (FileWriter writer = new FileWriter("sms_new_structure.json", false)) {
            writer.write(json);
            writer.flush();
        } catch (IOException ex) {
            log.info(ex.getMessage());
        }
    }
}
