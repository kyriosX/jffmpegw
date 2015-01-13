package com.kyrioslab.jffmpegw.attributes;

import com.kyrioslab.jffmpegw.command.Command;

public class CommonAttributes extends Attributes implements Command.Attributes.Common {

    public CommonAttributes() {

    }

    public String getOffset() {
        return attributes.get(OFFSET);
    }

    public void setOffset(String offset) {
        attributes.put(OFFSET, offset);
    }

    public String getInputFile() {
        return attributes.get(INPUT);
    }

    public void setInputFile(String inputFile) {
        attributes.put(INPUT, inputFile);
    }

    /**
     * Get duration in millis
     *
     * @return duration in millis
     */
    public String getDuration() {
        return attributes.get(DURATION);
    }

    /**
     * Set duration in millis
     *
     * @param duration in millis
     */
    public void setDuration(String duration) {
        attributes.put(DURATION, duration);
    }

    public String isVideoDisabled() {
        return attributes.get(VIDEO_DISABLED);
    }

    public void disableVideo() {
        attributes.put(VIDEO_DISABLED, "true");
    }

    public void enableVideo() {
        attributes.remove(VIDEO_DISABLED);
    }

    public String isAudioDisabled() {
        return attributes.get(AUDIO_DISABLED);
    }

    public void disableAudio() {
        attributes.put(AUDIO_DISABLED, "true");
    }

    public void enableAudio() {
        attributes.remove(AUDIO_DISABLED);
    }

    public String getFormat() {
        return attributes.get(FORMAT);
    }

    public void setFormat(String format) {
        attributes.put(FORMAT, format);
    }

    public void setOwerride(String owerride) {
        attributes.put(OWERRIDE, owerride);
    }

    public String isOwerride() {
        return attributes.get(OWERRIDE);
    }
}
