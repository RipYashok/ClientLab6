package commands;

public class Exit extends Command{
    public  Exit(){
        setTitle("exit");
        setDescription("exit - завершить программу (без сохранения в файл)");
    }

    public boolean execute(){
        return false;
    }

}
