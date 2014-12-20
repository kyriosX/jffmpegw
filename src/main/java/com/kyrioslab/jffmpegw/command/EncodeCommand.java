package com.kyrioslab.jffmpegw.command;

import java.util.ArrayList;
import java.util.List;

public class EncodeCommand implements Command {

    protected List<String> command = new ArrayList<String>();

    public EncodeCommand() {

    }

    public EncodeCommand(List<String> command) {
        this.command = command;
    }

    @Override
    public void addAttribute(String key) {
        command.add(key);
    }

    @Override
    public void addAttribute(String key, String value) {
        command.add(key);
        command.add(value);
    }

    @Override
    public List<String> getCommand() {
        return command;
    }
}
