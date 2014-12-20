package com.kyrioslab.jffmpegw.command;

import java.io.IOException;

public class CommandExecutor {

    public static Process execute(Command command) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder();
        return processBuilder.command(command.getCommand()).start();
    }

}
