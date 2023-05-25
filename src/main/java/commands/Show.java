package commands;

import commands.utils.CommandType;
import managers.utils.HashTable;
import models.StudyGroup;

public class Show extends Command{

    public Show(){
        setTitle("show");
        setDescription("show - выводит в стандартный поток вывода все элементы коллекции в строковом представлении");
        setType(CommandType.SHOW);
    }

    public void execute(HashTable collection){
        System.out.println(collection.toString());
    }
}
