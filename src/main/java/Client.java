
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import communication.Answer;
import managers.CommandManager;
import managers.utils.HashTable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketOption;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class Client {

    public static DatagramChannel start() throws IOException{
        DatagramChannel client = DatagramChannel.open();
        client.configureBlocking(false);
        client.connect(new InetSocketAddress("localhost", 666));
        System.out.println("Соединение установленно");
        return client;
    }

    public void send(DatagramChannel client, ByteBuffer sendBuffer, BufferedReader reader){
        sendBuffer.clear();
        ObjectMapper objectMapper = new ObjectMapper();
    }

    public static void main(String[] args) {
        CommandManager manager = new CommandManager();
        HashTable collection = new HashTable();
        try {
            DatagramChannel client = start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            ByteBuffer receiveBuffer = ByteBuffer.allocate(10240);
            ByteBuffer sendBuffer = ByteBuffer.allocate(10240);
            manager.run(reader, collection, client, sendBuffer, receiveBuffer);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}


