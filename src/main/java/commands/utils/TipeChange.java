package commands.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import managers.utils.HashTable;
import models.StudyGroup;

import java.io.*;

public class TipeChange {


    public static String ChangeInJSON(HashTable collection) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        String jsonCollection = mapper.writeValueAsString(collection);
        return jsonCollection;
    }
}
