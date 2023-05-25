package commands;

import commands.utils.CommandType;
import managers.utils.HashTable;

public class RemoveKey extends Command{
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public RemoveKey(){
        setTitle("remove_key");
        setDescription("remove_key null - удаляет элемент из коллекции по его ключу");
        setType(CommandType.REMOVEKEY);
    }
}
