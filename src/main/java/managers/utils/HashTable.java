package managers.utils;

import models.StudyGroup;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

public class HashTable extends Hashtable<String, StudyGroup> {
    ZonedDateTime timeTnitialization;
    public HashTable(){
        this.timeTnitialization = ZonedDateTime.now();
    }
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public ZonedDateTime getTimeTnitialization() {
        return timeTnitialization;
    }
    @Override
    public String toString() {
            Enumeration<StudyGroup> groups = this.elements();
            Enumeration<String> keys = this.keys();
            ArrayList<StudyGroup> allGroups = new ArrayList<>();
            ArrayList<String> allKeys = new ArrayList<>();
            while (groups.hasMoreElements() == true){
                allGroups.add(groups.nextElement());
                allKeys.add(keys.nextElement());
            }
            if (allGroups.size() == 0){
                return ANSI_YELLOW + "Коллекция пуста.";
            }
            String values = "";
            for (int i = 0; i < allGroups.size(); i++){
                 values += ANSI_YELLOW+  "key: " + ANSI_GREEN + allKeys.get(i) + allGroups.get(i).toString();
            }
            return values;
        }
    }
