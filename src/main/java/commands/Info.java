package commands;

import commands.utils.CommandType;
import managers.utils.HashTable;

import java.time.ZonedDateTime;

public class Info extends Command{

    public Info(){
        setTitle("info");
        setDescription("info - выводит в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
        setType(CommandType.INFO);
    }
    public static final String ANSI_GREEN = "\u001B[32m";
    public void execute(HashTable collection){
        System.out.println(ANSI_GREEN + "Тип коллекции - Hashtable");
        System.out.println(ANSI_GREEN + "Дата инициализации - " + collection.getTimeTnitialization());
        System.out.println(ANSI_GREEN + "Количество элементов - " + collection.size());
    }
}
