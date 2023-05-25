package commands;

import commands.utils.TipeChange;
import managers.utils.HashTable;
import models.StudyGroup;

import java.io.FileOutputStream;
import java.io.IOException;


public class Save extends Command{

    public Save(){
        setTitle("save");
        setDescription("save - сохраняет коллекцию в файл");
    }

    public void excute (HashTable collection) throws IOException {
        FileOutputStream fileOutPut = new FileOutputStream("C:\\GitHub\\Lab5\\FileCollection.txt");
        fileOutPut.write(TipeChange.ChangeInJSON(collection).getBytes());
    }

}
