package com.kyrioslab.jffmpegw.command;

import java.util.List;

public class EncodeCommand extends Command {

    private static final int FFMPEG_INDEX_DEFAULT = 0;
    private static final int INPUT_INDEX_DEFAULT = 1;

    private String inputFormat;
    private String outputFormat;

    public EncodeCommand() {
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
    public void setFfmpegLocation(String ffmpegLocation) {
        command.set(FFMPEG_INDEX_DEFAULT, ffmpegLocation);
    }

    @Override
    public void setInput(String inputFile) {
        if (command.size() < 2) {
            command.add(Attributes.Common.INPUT);
            command.add(inputFile);
        } else {
            command.set(INPUT_INDEX_DEFAULT, Attributes.Common.INPUT);
            command.set(INPUT_INDEX_DEFAULT + 1, inputFile);
        }
    }

    @Override
    public List<String> getCommand() {
        return command;
    }

    public void setFormats(String inputFormat, String outputFormat) {
        this.inputFormat = inputFormat;
        this.outputFormat = outputFormat;
    }

    public String getInputFormat() {
        return inputFormat;
    }

    public String getOutputFormat() {
        return outputFormat;
    }
}
