package com.kyrioslab.jffmpegw.command;

import com.kyrioslab.jffmpegw.attributes.AudioAttributes;
import com.kyrioslab.jffmpegw.attributes.CommonAttributes;
import com.kyrioslab.jffmpegw.attributes.VideoAttributes;

import java.util.List;
import java.util.Map;

public abstract class CommandBuilder {

    protected CommonAttributes commonAttributes = new CommonAttributes();
    protected AudioAttributes audioAttributes = new AudioAttributes();
    protected VideoAttributes videoAttributes = new VideoAttributes();

    protected Command command;

    public Command build(){

        for (Map.Entry<String, String> atrr : commonAttributes.getAttributes().entrySet()){
            command.addAttribute(atrr.getKey(), atrr.getValue());
        }

        for (Map.Entry<String, String> atrr : audioAttributes.getAttributes().entrySet()){
            command.addAttribute(atrr.getKey(), atrr.getValue());
        }

        for (Map.Entry<String, String> atrr : videoAttributes.getAttributes().entrySet()){
            command.addAttribute(atrr.getKey(), atrr.getValue());
        }

        return command;
    }
}
