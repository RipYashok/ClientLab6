package commands;

import commands.utils.CommandType;
import managers.utils.HashTable;
import models.StudyGroup;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;

public class RemoveLower extends Command{

    private Integer value;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public RemoveLower(){
        setTitle("remove_lower");
        setDescription("remove_lower {element} - удаляет из коллекции все элементы, значение studentsCount которых, меньшие, чем заданное");
        setType(CommandType.REMOVELOWER);
    }

    public void execute(HashTable collection, Integer value) throws IOException {
        Enumeration<StudyGroup> groups = collection.elements();
        Enumeration<String> keys = collection.keys();
        while (groups.hasMoreElements() == true){
            if (value > groups.nextElement().getStudentsCount()){
                collection.remove(keys.nextElement());
            }
        }
    }
}
