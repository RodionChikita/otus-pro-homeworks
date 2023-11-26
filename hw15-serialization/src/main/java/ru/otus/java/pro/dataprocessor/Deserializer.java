package ru.otus.java.pro.dataprocessor;

import org.json.simple.parser.ParseException;
import ru.otus.java.pro.oldStructure.SmsData;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public interface Deserializer {
    SmsData data(FileReader fileReader) throws IOException, ParseException;
}
