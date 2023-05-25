package commands;

import commands.utils.CommandType;
import managers.utils.HashTable;
import models.StudyGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

public class MaxByID extends Command{
    public MaxByID(){
        setTitle("max_by_id");
        setDescription("max_by_id - выводит любой объект из коллекции, значение поля id которого является максимальным");
        setType(CommandType.MAXID);
    }

    public void execute(HashTable collection){
        Enumeration<StudyGroup> groups = collection.elements();
        Enumeration<String> keys = collection.keys();
        ArrayList<String> allKeys = new ArrayList<>();
        ArrayList<Long> allId = new ArrayList<>();
        while (groups.hasMoreElements() == true){
            allId.add(groups.nextElement().getId());
            allKeys.add(keys.nextElement());
        }
        System.out.print(collection.get(allKeys.get(allId.indexOf(Collections.max(allId)))));
    }
}
