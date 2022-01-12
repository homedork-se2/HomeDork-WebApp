package com.example.HomeDorkWebApp.model;

import java.util.ArrayList;

public class PersonalizedCommands {

    private ArrayList<String> commands;
    private String commandName;
    private String commandId;
    private String toggleValue;

    public PersonalizedCommands(ArrayList<String> commands, String commandName, String commandId) {
        this.commands = commands;
        this.commandName = commandName;
        this.commandId = commandId;
    }

    public PersonalizedCommands(ArrayList<String> commands, String commandName) {
        this.commands = commands;
        this.commandName = commandName;
    }

    @Override
    public String toString() {
        return "PersonalizedCommands{" +
                "commands=" + commands +
                ", commandName='" + commandName + '\'' +
                ", commandId='" + commandId + '\'' +
                '}';
    }

    public String getToggleValue() {
        return toggleValue;
    }

    public void setToggleValue(String toggleValue) {
        this.toggleValue = toggleValue;
    }

    public ArrayList<String> getCommands() {
        return commands;
    }

    public void setCommands(ArrayList<String> commands) {
        this.commands = commands;
    }

    public String getCommandName() {
        return commandName;
    }

    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandId() {
        return commandId;
    }

    public void setCommandId(String commandId) {
        this.commandId = commandId;
    }
}
