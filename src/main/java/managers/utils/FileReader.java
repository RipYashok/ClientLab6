package managers.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.*;

public class FileReader {

    public HashTable saveCollaction(String string) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        String file = string;
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String text = (reader.readLine());
        HashTable mapping = mapper.readValue(text, HashTable.class);
        return mapping;
    }
}
