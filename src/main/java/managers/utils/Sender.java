package managers.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import commands.*;
import models.StudyGroup;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class Sender {
    public void insertNullSender(DatagramChannel client, ByteBuffer buffer, StudyGroup group, InsertNull insert) throws IOException {
        buffer.clear();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        String jsonCommand = objectMapper.writeValueAsString(insert);
        buffer.put(jsonCommand.getBytes());
        buffer.flip();
        client.send(buffer, client.getRemoteAddress());
        buffer.clear();
        String jsonSend = objectMapper.writeValueAsString(group);
        buffer.put(jsonSend.getBytes());
        buffer.flip();
        client.send(buffer, client.getRemoteAddress());
    }
    public void showSender(DatagramChannel client, ByteBuffer buffer, Show show) throws IOException {
        buffer.clear();
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonCommand = objectMapper.writeValueAsString(show);
        buffer.put(jsonCommand.getBytes());
        buffer.flip();
        client.send(buffer, client.getRemoteAddress());

    }
    public void clearSender(DatagramChannel client, ByteBuffer buffer, Clear clear) throws IOException {
        buffer.clear();
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonCommand = objectMapper.writeValueAsString(clear);
        buffer.put(jsonCommand.getBytes());
        buffer.flip();
        client.send(buffer, client.getRemoteAddress());
    }
    public void removeKeySender(DatagramChannel client, ByteBuffer buffer, RemoveKey removeKey) throws IOException {
        buffer.clear();
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonCommand = objectMapper.writeValueAsString(removeKey);
        buffer.put(jsonCommand.getBytes());
        buffer.flip();
        client.send(buffer, client.getRemoteAddress());
    }
    public void maxByIDSender(DatagramChannel client, ByteBuffer buffer, MaxByID maxByID) throws IOException {
        buffer.clear();
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonCommand = objectMapper.writeValueAsString(maxByID);
        buffer.put(jsonCommand.getBytes());
        buffer.flip();
        client.send(buffer, client.getRemoteAddress());
    }
    public void averageOfStudentsCountSender(DatagramChannel client, ByteBuffer buffer, AverageOfStudentsCount averageOfStudentsCount) throws IOException {
        buffer.clear();
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonCommand = objectMapper.writeValueAsString(averageOfStudentsCount);
        buffer.put(jsonCommand.getBytes());
        buffer.flip();
        client.send(buffer, client.getRemoteAddress());
    }
    public void removeAllByOfEducationSender(DatagramChannel client, ByteBuffer buffer, RemoveAllByOfEducation removeAllByOfEducation) throws IOException {
        buffer.clear();
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonCommand = objectMapper.writeValueAsString(removeAllByOfEducation);
        buffer.put(jsonCommand.getBytes());
        buffer.flip();
        client.send(buffer, client.getRemoteAddress());
    }
    public void removeLowerSender(DatagramChannel client, ByteBuffer buffer, RemoveLower removeLower) throws IOException {
        buffer.clear();
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonCommand = objectMapper.writeValueAsString(removeLower);
        buffer.put(jsonCommand.getBytes());
        buffer.flip();
        client.send(buffer, client.getRemoteAddress());
    }
    public void replaceIfLoweSender(DatagramChannel client, ByteBuffer buffer, ReplaceIfLowe replaceIfLowe) throws IOException {
        buffer.clear();
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonCommand = objectMapper.writeValueAsString(replaceIfLowe);
        buffer.put(jsonCommand.getBytes());
        buffer.flip();
        client.send(buffer, client.getRemoteAddress());
    }
    public void historySender(DatagramChannel client, ByteBuffer buffer, History history) throws IOException {
        buffer.clear();
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonCommand = objectMapper.writeValueAsString(history);
        buffer.put(jsonCommand.getBytes());
        buffer.flip();
        client.send(buffer, client.getRemoteAddress());
    }
    public void infoSender(DatagramChannel client, ByteBuffer buffer, Info info) throws IOException {
        buffer.clear();
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonCommand = objectMapper.writeValueAsString(info);
        buffer.put(jsonCommand.getBytes());
        buffer.flip();
        client.send(buffer, client.getRemoteAddress());
    }
}
