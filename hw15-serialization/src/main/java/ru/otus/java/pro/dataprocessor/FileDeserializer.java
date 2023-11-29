package ru.otus.java.pro.dataprocessor;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import ru.otus.java.pro.oldstructure.SmsData;

import java.io.FileReader;
import java.io.IOException;

public class FileDeserializer implements Deserializer {

    @Override
    public SmsData data(FileReader fileReader) throws IOException, ParseException {
        ObjectMapper objectMapper = new ObjectMapper();
        Object o = new JSONParser().parse(fileReader);
        JSONObject j = (JSONObject) o;
        String json = j.toJSONString();
        return objectMapper.readValue(json, SmsData.class);
    }
}
