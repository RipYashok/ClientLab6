package commands;

public class Help extends Command {

    public Help() {
        setTitle("help");
        setDescription("help - выводит справку по доступным командам");
    }

    public static final String ANSI_YELLOW = "\u001B[33m";
    public void execute(){
        InsertNull insertNull = new InsertNull();
        Save save = new Save();
        Show show = new Show();
        Exit exit = new Exit();
        Clear clear = new Clear();
        RemoveKey removeKey = new RemoveKey();
        ExecuteScript executeScript = new ExecuteScript();
        MaxByID maxByID = new MaxByID();
        AverageOfStudentsCount averageOfStudentsCount = new AverageOfStudentsCount();
        RemoveAllByOfEducation removeAllByOfEducation = new RemoveAllByOfEducation();
        ReplaceIfLowe replaceIfLowe = new ReplaceIfLowe();
        History history = new History();
        RemoveLower removeLower = new RemoveLower();
        Update undate = new Update();
        Info info = new Info();
        Help help = new Help();
        System.out.println(ANSI_YELLOW + insertNull.getDescription());
        System.out.println(ANSI_YELLOW + save.getDescription());
        System.out.println(ANSI_YELLOW + show.getDescription());
        System.out.println(ANSI_YELLOW + exit.getDescription());
        System.out.println(ANSI_YELLOW + clear.getDescription());
        System.out.println(ANSI_YELLOW + removeKey.getDescription());
        System.out.println(ANSI_YELLOW + executeScript.getDescription());
        System.out.println(ANSI_YELLOW + maxByID.getDescription());
        System.out.println(ANSI_YELLOW + averageOfStudentsCount.getDescription());
        System.out.println(ANSI_YELLOW + removeAllByOfEducation.getDescription());
        System.out.println(ANSI_YELLOW + replaceIfLowe.getDescription());
        System.out.println(ANSI_YELLOW + history.getDescription());
        System.out.println(ANSI_YELLOW + removeLower.getDescription());
        System.out.println(ANSI_YELLOW + undate.getDescription());
        System.out.println(ANSI_YELLOW + info.getDescription());
        System.out.println(ANSI_YELLOW + help.getDescription());



    }
}

