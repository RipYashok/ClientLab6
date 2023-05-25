package commands;

import commands.utils.CommandType;
import managers.utils.HashTable;

public class Clear extends Command{
    public Clear(){
        setTitle("clear");
        setDescription("clear - очищает коллекцию");
        setType(CommandType.CLEAR);
    }
    public void execute(HashTable collection){
        collection.clear();
    }
}
