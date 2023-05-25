package commands;

import managers.utils.HashTable;
import models.StudyGroup;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

public class Update extends Command{
    public Update(){
        setTitle("update");
        setDescription("update id {element} - обновляет значение элемента коллекции, id которого равен заданному");
    }
    public static final String ANSI_RED = "\u001B[31m";
    public void execute(HashTable collection, Long id, BufferedReader reader) throws IOException {
        InsertNull insertNull = new InsertNull();
        Enumeration<StudyGroup> groups = collection.elements();
        ArrayList<Long> allID = new ArrayList<>();
        Enumeration<String> keys = collection.keys();
        ArrayList<String> allKeys = new ArrayList<>();
        while (groups.hasMoreElements() == true){
            allID.add(groups.nextElement().getId());
            allKeys.add(keys.nextElement());
        }
        if (allID.contains(id)){
            StudyGroup newGroup = insertNull.execute(reader);
            newGroup.setId(id);
            collection.put(allKeys.get(allID.indexOf(id)), newGroup);
            } else {
            System.out.println(ANSI_RED + "Элемента с таким ID нет в коллекции");
        }
    }
}
