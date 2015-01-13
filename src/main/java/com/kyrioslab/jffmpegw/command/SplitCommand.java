package com.kyrioslab.jffmpegw.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ivan Kirilyuk on 28.12.14.
 *
 */
public class SplitCommand extends Command {

    /**
     * Command for splitting video into segmentTime parts
     *
     * @param FFMPEGLocation
     * @param input
     * @param segmentTime
     * @param map
     */
    public SplitCommand(String FFMPEGLocation,
                        String input,
                        int segmentTime,
                        int map) {

        command.addAll(Arrays.asList(FFMPEGLocation,
                Attributes.Common.INPUT,
                input,
                Attributes.Common.FORMAT,
                Attributes.Common.SEGMENT,
                Attributes.Common.SEGMENT_TIME,
                String.valueOf(segmentTime),
                Attributes.Common.CODECS,
                Attributes.Common.CODEC_COPY,
                Attributes.Common.MAP,
                String.valueOf(map)));
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
