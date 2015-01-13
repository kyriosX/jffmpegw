package com.kyrioslab.jffmpegw.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ivan Kirilyuk on 28.12.14.
 *
 */
public class MergeCommand extends Command {

    /**
     * Command for merging video from parts
     */
    public MergeCommand(String FFMPEGLocation,
                        String list, String outputName) {

        command.addAll(Arrays.asList(FFMPEGLocation,
                Attributes.Common.FORMAT,
                Attributes.Common.CONCAT,
                Attributes.Common.INPUT,
                list,
                Attributes.Common.CODECS,
                Attributes.Common.CODEC_COPY,
                outputName));
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
