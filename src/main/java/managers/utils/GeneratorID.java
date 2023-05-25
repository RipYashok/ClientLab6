package managers.utils;

public class GeneratorID {

    public static Long newId(){
        return (long) ((Math.random() * 485123659) + 1);
    }
}