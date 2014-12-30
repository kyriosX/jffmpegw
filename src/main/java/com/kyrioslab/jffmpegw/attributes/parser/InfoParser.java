package com.kyrioslab.jffmpegw.attributes.parser;

import com.kyrioslab.jffmpegw.attributes.AudioAttributes;
import com.kyrioslab.jffmpegw.attributes.CommonAttributes;
import com.kyrioslab.jffmpegw.attributes.VideoAttributes;

public abstract class InfoParser {

    protected CommonAttributes commonAttributes = new CommonAttributes();
    protected AudioAttributes audioAttributes = new AudioAttributes();
    protected VideoAttributes videoAttributes = new VideoAttributes();

    public abstract void parse();

    public CommonAttributes getCommonAttributes() {
        return commonAttributes;
    }

    public AudioAttributes getAudioAttributes() {
        return audioAttributes;
    }

    public VideoAttributes getVideoAttributes() {
        return videoAttributes;
    }
}
