package models;

public class Person {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private String passportID; //Строка не может быть пустой, Длина строки не должна быть больше 20, Поле может быть null
    private Color eyeColor; //Поле не может быть null
    private Color hairColor; //Поле не может быть null
    private Location location; //Поле не может быть null
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public String getName() {
        return name;
    }

    public String getPassportID() {
        return passportID;
    }

    public Color getEyeColor() {
        return eyeColor;
    }

    public Color getHairColor() {
        return hairColor;
    }

    public Location getLocation() {
        return location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassportID(String passportID) {
        this.passportID = passportID;
    }

    public void setEyeColor(Color eyeColor) {
        this.eyeColor = eyeColor;
    }

    public void setHairColor(Color hairColor) {
        this.hairColor = hairColor;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return ANSI_GREEN + name + ANSI_YELLOW + "; пароль: " + ANSI_GREEN + passportID + ANSI_YELLOW + "; цвет глаз: " + ANSI_GREEN + eyeColor.toString()
               + ANSI_YELLOW + "; цвет волос: " + ANSI_GREEN + hairColor.toString() + ANSI_YELLOW + "; место проживания: " + ANSI_GREEN + location.toString();
    }
}
