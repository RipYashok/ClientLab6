package commands;

import commands.utils.CommandType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Serializable;

public abstract class Command implements Serializable {

    private String title;
    private String description;
    private CommandType type;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CommandType getType() {
        return type;
    }

    public void setType(CommandType type) {
        this.type = type;
    }
}
