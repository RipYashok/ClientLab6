import managers.CommandManager;
import managers.utils.FileReader;
import managers.utils.HashTable;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException{
        HashTable collection = new HashTable();
        InputStreamReader line = new InputStreamReader(System.in);
        if (line.ready() == false){
            line = new InputStreamReader(System.in);
        }
        BufferedReader reader = new BufferedReader(line);
        CommandManager commandManager = new CommandManager();
        FileReader fileReader = new FileReader();
        try{
            collection.putAll(fileReader.saveCollaction(args[0]));
        }catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException){

        }catch (FileNotFoundException fileNotFoundException){
            System.out.println("Файл не найден. Данные не считаны.");
        }
//        commandManager.run(reader, collection);
    }
}

