package commands;

import managers.utils.HashTable;
import models.FormOfEducation;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExecuteScript extends Command{
    public ExecuteScript(){
        setTitle("execute_script");
        setDescription("execute_script file_name - считывает и исполяет скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
    }
    InsertNull insertNull = new InsertNull();
    Save save = new Save();
    Show show = new Show();
    Clear clear = new Clear();
    RemoveKey removeKey = new RemoveKey();
    MaxByID maxByID = new MaxByID();
    AverageOfStudentsCount averageOfStudentsCount = new AverageOfStudentsCount();
    RemoveAllByOfEducation removeAllByOfEducation = new RemoveAllByOfEducation();
    ReplaceIfLowe replaceIfLowe = new ReplaceIfLowe();
    History history = new History();
    RemoveLower removeLower = new RemoveLower();
    Update undate = new Update();
    Info info = new Info();
    Help help = new Help();
    ArrayList<String> commandNameList = new ArrayList<>(Arrays.asList(insertNull.getTitle(), save.getTitle(), show.getTitle(),
            clear.getTitle(), removeKey.getTitle(), maxByID.getTitle(), averageOfStudentsCount.getTitle(), removeAllByOfEducation.getTitle(),
            replaceIfLowe.getTitle(), history.getTitle(), removeLower.getTitle(), undate.getTitle(), info.getTitle(), help.getTitle()));
    public void execute(String fileName, HashTable collection) throws IOException{

        try {
            File file = new File(fileName);
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            while (line != null) {
                ArrayList<String> commandHistory = new ArrayList<>(Arrays.asList("", "", "", "", "", "", "", "", "", "", ""));
                List<String> commandString = new ArrayList<>(Arrays.asList(line.split(" ")));
                history.createHistory(commandHistory, commandString.get(0));
                if (commandString.get(0).equals(insertNull.getTitle())) {
                    collection.put(commandString.get(1), insertNull.execute(reader));
                } else if (commandString.get(0).equals(show.getTitle())) {
                    show.execute(collection);
                } else if (commandString.get(0).equals(save.getTitle())) {
                    save.excute(collection);
                } else if (commandString.get(0).equals(clear.getTitle())) {
                    clear.execute(collection);
                } else if (commandString.get(0).equals(removeKey.getTitle())) {
//                    removeKey.execute(collection, commandString.get(1));
                } else if (commandString.get(0).equals(maxByID.getTitle())) {
                    maxByID.execute(collection);
                } else if (commandString.get(0).equals(averageOfStudentsCount.getTitle())) {
                    averageOfStudentsCount.execute(collection);
                } else if (commandString.get(0).equals(removeAllByOfEducation.getTitle())) {
                    removeAllByOfEducation.execute(collection, FormOfEducation.valueOf(commandString.get(1)));
                } else if (commandString.get(0).equals(replaceIfLowe.getTitle())) {
                    collection.put(commandString.get(1), replaceIfLowe.execute(collection, commandString.get(1), reader));
                } else if (commandString.get(0).equals(history.getTitle())) {
                    history.execute(commandHistory, commandNameList);
                } else if (commandString.get(0).equals(removeLower.getTitle())) {
                    removeLower.execute(collection, Integer.valueOf(commandString.get(1)));
                } else if (commandString.get(0).equals(undate.getTitle())) {
                    undate.execute(collection, Long.valueOf(commandString.get(1)), reader);
                } else if (commandString.get(0).equals(info.getTitle())) {
                    info.execute(collection);
                } else if (commandString.get(0).equals(help.getTitle())) {
                    help.execute();
                } else if (line.isBlank()) {
                    System.out.print("");
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }
}
