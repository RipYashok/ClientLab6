package managers;

import com.fasterxml.jackson.databind.ObjectMapper;
import commands.*;
import communication.Answer;
import managers.utils.HashTable;
import managers.utils.Sender;
import models.FormOfEducation;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandManager {


    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";


    Sender sender = new Sender();
    InsertNull insertNull = new InsertNull();
    Save save = new Save();
    Show show = new Show();
    Exit exit = new Exit();
    Clear clear = new Clear();
    RemoveKey removeKey = new RemoveKey();
    ExecuteScript executeScript = new ExecuteScript();
    MaxByID maxByID = new MaxByID();
    AverageOfStudentsCount averageOfStudentsCount = new AverageOfStudentsCount();
    RemoveAllByOfEducation removeAllByOfEducation = new RemoveAllByOfEducation();
    ReplaceIfLowe replaceIfLowe = new ReplaceIfLowe();
    History history = new History();
    RemoveLower removeLower = new RemoveLower();
    Update undate = new Update();
    Info info = new Info();
    Help help = new Help();
    ArrayList<String> commandNameList = new ArrayList<>(Arrays.asList(insertNull.getTitle(), save.getTitle(), show.getTitle(), exit.getTitle(),
            clear.getTitle(), removeKey.getTitle(), executeScript.getTitle(), maxByID.getTitle(), averageOfStudentsCount.getTitle(), removeAllByOfEducation.getTitle(),
            replaceIfLowe.getTitle(), history.getTitle(), removeLower.getTitle(), undate.getTitle(), info.getTitle(), help.getTitle()));

    public void run(BufferedReader reader, HashTable collection, DatagramChannel client, ByteBuffer sendBuffer, ByteBuffer receiveBuffer) throws IOException{
        ArrayList<String> commandHistory = new ArrayList<>(Arrays.asList("", "", "", "", "", "", "", "", "", "", ""));
        boolean flag = true;
        while (flag){
            try {
                String string = reader.readLine().trim();
                List<String> commandString = new ArrayList<>(Arrays.asList(string.split(" ")));
                history.createHistory(commandHistory, commandString.get(0));
                if (commandString.get(0).equals(exit.getTitle())) {
                    break;
                } else if (commandString.get(0).equals(insertNull.getTitle()) & commandString.size() == 2) {
                    insertNull.setKey(commandString.get(1));
                    sender.insertNullSender(client, sendBuffer, insertNull.execute(reader), insertNull);
                } else if (commandString.get(0).equals(show.getTitle())){
                    sender.showSender(client, sendBuffer, show);
                } else if (commandString.get(0).equals(clear.getTitle())){
                    sender.clearSender(client, sendBuffer, clear);
                } else if (commandString.get(0).equals(removeKey.getTitle()) & commandString.size() == 2){
                    removeKey.setKey(commandString.get(1));
                    sender.removeKeySender(client, sendBuffer, removeKey);
                } else if (commandString.get(0).equals(executeScript.getTitle())){
                    executeScript.execute(commandString.get(1), collection);
                } else if (commandString.get(0).equals(maxByID.getTitle())){
                    sender.maxByIDSender(client, sendBuffer, maxByID);
                } else if (commandString.get(0).equals(averageOfStudentsCount.getTitle())){
                    sender.averageOfStudentsCountSender(client, sendBuffer, averageOfStudentsCount);
                } else if (commandString.get(0).equals(removeAllByOfEducation.getTitle())){
                    removeAllByOfEducation.setEducation(FormOfEducation.valueOf(commandString.get(1)));
                    sender.removeAllByOfEducationSender(client, sendBuffer, removeAllByOfEducation);
                } else if (commandString.get(0).equals(replaceIfLowe.getTitle()) & commandString.size() == 3){
                    replaceIfLowe.setKey(commandString.get(1));
                    replaceIfLowe.setValue(Integer.valueOf(commandString.get(2)));
                    sender.replaceIfLoweSender(client, sendBuffer, replaceIfLowe);
                } else if (commandString.get(0).equals(history.getTitle())){
                    sender.historySender(client, sendBuffer, history);
                } else if (commandString.get(0).equals(removeLower.getTitle())){
                    removeLower.setValue(Integer.valueOf(commandString.get(1)));
                    sender.removeLowerSender(client, sendBuffer, removeLower);
                } else if (commandString.get(0).equals(undate.getTitle())){
                    undate.execute(collection, Long.valueOf(commandString.get(1)), reader);
                } else if (commandString.get(0).equals(info.getTitle())){
                    sender.infoSender(client, sendBuffer, info);
                } else if (commandString.get(0).equals(help.getTitle())){
                    help.execute();
                }
                else if (string.isBlank()){
                    System.out.print("");
                }
                else {
                    System.out.println(ANSI_RED + "Такой команды не существует" + "\n" + ANSI_YELLOW + "Введите help, чтобы увидеть весь список доступных команд");
                    continue;
                }
                receiveBuffer.clear();
                SocketAddress serverAddress = null;
                while (serverAddress == null) {
                    serverAddress = client.receive(receiveBuffer);
                    // если ответ не получен, ждем некоторое время перед следующей попыткой
                    if (serverAddress == null) {
                        try {
                            System.out.println("Ждем ответа");
                            Thread.sleep(1000); // ждем 1 секунду
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                if (serverAddress != null) {
                    receiveBuffer.flip();
                    ObjectMapper objectMapper = new ObjectMapper();
                    String jsonReceive = new String(receiveBuffer.array(), 0, receiveBuffer.remaining());;
                    Answer answer = objectMapper.readValue(jsonReceive, Answer.class);
                    System.out.println(answer.getText());
                }

            } catch (IndexOutOfBoundsException indexOutOfBoundsException){
                System.out.println(ANSI_YELLOW + "Введите help, чтобы увидеть весь список доступных команд");
            } catch (IllegalArgumentException IllegalArgumentException){
                System.out.println(ANSI_RED + "Неверное значение аргумента");
            } catch (NullPointerException nullPointerException){
                System.out.println("");
            }
        }
        client.close();
        System.out.println("Отключение от сервера");
    }
}