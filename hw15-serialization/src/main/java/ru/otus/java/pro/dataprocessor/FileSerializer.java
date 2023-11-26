package ru.otus.java.pro.dataprocessor;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.otus.java.pro.newStructure.SmsDataNewStructure;

import java.io.FileWriter;
import java.io.IOException;

public class FileSerializer implements Serializer {
    @Override
    public void serialize(SmsDataNewStructure data) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(data);
        System.out.println(json);
        try (FileWriter writer = new FileWriter("sms_new_structure.json", false)) {
            writer.write(json);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
