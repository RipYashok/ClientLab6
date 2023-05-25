package commands;

import commands.utils.CommandType;

import java.util.ArrayList;

public class History extends Command{
    public History(){
        setTitle("history");
        setDescription("history - выводит последние 11 команд (без их аргументов)");
        setType(CommandType.HISTORY);
    }
    public static final String ANSI_GREEN = "\u001B[32m";

    public void createHistory(ArrayList<String> commandHistory, String command){
        if (command.isBlank() == false){
            commandHistory.add(command);
        }
    }

    public void execute(ArrayList<String> commandHistory, ArrayList<String> commandNameList){
        for (int i = commandHistory.size()-11; i < commandHistory.size() - 1; i++){
            if (commandNameList.contains(commandHistory.get(i))){
                System.out.println(ANSI_GREEN + commandHistory.get(i));
            }
        }
    }
}
