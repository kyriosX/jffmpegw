package com.kyrioslab.jffmpegw.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ivan Kirilyuk on 10.01.15.
 *
 */
public class ProbeInfoCommand extends Command{

    /**
     * Command for getting media file attributes
     * in json format.
     */
    public ProbeInfoCommand(String FFMPEGProbeLocation,
                            String inputFile) {

        command.addAll(Arrays.asList(
                FFMPEGProbeLocation,
                "-v",
                "quiet",
                "-print_format",
                "json",
                "-show_format",
                "-show_streams",
                "-i",
                inputFile));
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
        command.set(0,ffmpegLocation);
    }

    @Override
    public List<String> getCommand() {
        return command;
    }
}
