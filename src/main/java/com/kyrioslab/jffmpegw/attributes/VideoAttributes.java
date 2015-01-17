package com.kyrioslab.jffmpegw.attributes;

import com.kyrioslab.jffmpegw.command.Command;

public class VideoAttributes extends Attributes implements Command.Attributes.Video {

    public VideoAttributes() {

    }

    @Override
    public String getCodec() {
        return attributes.get(CODEC);
    }

    @Override
    public void setCodec(String codec) {
        attributes.put(CODEC, codec);
    }

    @Override
    public String getTag() {
        return attributes.get(TAG);
    }

    @Override
    public void setTag(String tag) {
        attributes.put(TAG, tag);
    }

    @Override
    public String getBitRate() {
        return attributes.get(BIT_RATE);
    }

    @Override
    public void setBitRate(String bitRate) {
        attributes.put(BIT_RATE, bitRate);
    }

    @Override
    public String getFrameRate() {
        return attributes.get(FRAME_RATE);
    }

    @Override
    public void setFrameRate(String frameRate) {
        attributes.put(FRAME_RATE, frameRate);
    }

    @Override
    public String getVideoSize() {
        return attributes.get(SIZE);
    }

    @Override
    public void setVideoSize(String size) {
        attributes.put(SIZE, size);
    }

    @Override
    public String getAspectRatio() {
        return attributes.get(ASPECT_RATIO);
    }

    @Override
    public void setAspectRatio(String aspect) {
        attributes.put(ASPECT_RATIO, aspect);
    }

    @Override
    public String getPixelFormat() {
        return attributes.get(PIXEL_FORMAT);
    }

    @Override
    public void setPixelFormat(String pixelFormat) {
        attributes.put(PIXEL_FORMAT, pixelFormat);
    }

    @Override
    public String isDisabled() {
        return attributes.get(DISABLE_VIDEO);
    }

    @Override
    public void setDisabled() {
        attributes.put(DISABLE_VIDEO, "");
    }

}
