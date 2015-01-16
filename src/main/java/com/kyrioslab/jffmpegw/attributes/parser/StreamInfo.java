package com.kyrioslab.jffmpegw.attributes.parser;

import java.io.Serializable;

/**
 * Created by Ivan Kirilyuk on 10.01.15.
 *
 */
public class StreamInfo implements Serializable {

    private int index;
    private String codecName;
    private String codecLongName;
    private String codecType;
    private String width;
    private String height;
    private String displayAspectRatio;
    private String pixFmt;
    private String avgFrameRate;
    private String duration;
    private String bitRate;
    private String sampleRate;
    private String channels;

    public StreamInfo() {
    }

    public String getCodecName() {
        return codecName;
    }

    public void setCodecName(String codecName) {
        this.codecName = codecName;
    }

    public String getCodecLongName() {
        return codecLongName;
    }

    public void setCodecLongName(String codecLongName) {
        this.codecLongName = codecLongName;
    }

    public String getCodecType() {
        return codecType;
    }

    public void setCodecType(String codecType) {
        this.codecType = codecType;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getAvgFrameRate() {
        return avgFrameRate;
    }

    public void setAvgFrameRate(String avgFrameRate) {
        this.avgFrameRate = avgFrameRate;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getBitRate() {
        return bitRate;
    }

    public void setBitRate(String bitRate) {
        this.bitRate = bitRate;
    }

    public String getSampleRate() {
        return sampleRate;
    }

    public void setSampleRate(String sampleRate) {
        this.sampleRate = sampleRate;
    }

    public String getChannels() {
        return channels;
    }

    public void setChannels(String channels) {
        this.channels = channels;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getDisplayAspectRatio() {
        return displayAspectRatio;
    }

    public void setDisplayAspectRatio(String displayAspectRatio) {
        this.displayAspectRatio = displayAspectRatio;
    }

    public String getPixFmt() {
        return pixFmt;
    }

    public void setPixFmt(String pixFmt) {
        this.pixFmt = pixFmt;
    }
}
