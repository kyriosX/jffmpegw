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
    public long getDuration() {
        String duration = attributes.get(DURATION);
        if (duration != null) {
            return Integer.parseInt(duration);
        }
        return -1;
    }

    /**
     * Set duration in millis
     *
     * @param duration in millis
     */
    public void setDuration(long duration) {
        attributes.put(DURATION, String.valueOf(duration));
    }

    public boolean isVideoDisabled() {
        String isDisabled = attributes.get(VIDEO_DISABLED);
        return isDisabled != null && Boolean.parseBoolean(isDisabled);
    }

    public void disableVideo() {
        attributes.put(VIDEO_DISABLED, "true");
    }

    public void enableVideo() {
        attributes.remove(VIDEO_DISABLED);
    }

    public boolean isAudioDisabled() {
        String isDisabled = attributes.get(AUDIO_DISABLED);
        return isDisabled != null && Boolean.parseBoolean(isDisabled);
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

    public boolean isOwerride() {
        String isOwerride = attributes.get(OWERRIDE);
        return isOwerride != null && Boolean.parseBoolean(isOwerride);
    }
}
