package com.kyrioslab.jffmpegw.attributes;

import com.kyrioslab.jffmpegw.command.Command;

public class CommonAttributes extends Attributes implements Command.Attributes.Common {

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
     * Get duration in seconds
     *
     * @return duration in seconds
     */
    public int getDuration() {
        return Integer.parseInt(attributes.get(DURATION));
    }

    /**
     * Set duration in seconds
     *
     * @param duration in seconds
     */
    public void setDuration(int duration) {
        attributes.put(DURATION, String.valueOf(duration));
    }

    public boolean isVideoDisabled() {
        return Boolean.parseBoolean(attributes.get(VIDEO_DISABLED));
    }

    public void disableVideo() {
        attributes.put(VIDEO_DISABLED, "true");
    }

    public void enableVideo() {
        attributes.remove(VIDEO_DISABLED);
    }

    public boolean isAudioDisabled() {
        return Boolean.parseBoolean(attributes.get(AUDIO_DISABLED));
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

    public void setOwerride(boolean owerride) {
        attributes.put(OWERRIDE, String.valueOf(owerride));
    }

    public boolean isOweride() {
        return Boolean.parseBoolean(attributes.get(OWERRIDE));
    }
}
