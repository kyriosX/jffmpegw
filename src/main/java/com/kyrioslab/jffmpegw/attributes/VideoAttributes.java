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
    public double getFrameRate() {
        String frameRate = attributes.get(FRAME_RATE);
        if (frameRate != null) {
            return Double.parseDouble(frameRate);
        }
        return -1;
    }

    @Override
    public void setFrameRate(double frameRate) {
        attributes.put(FRAME_RATE, String.valueOf(frameRate));
    }

    @Override
    public VideoSize getVideoSize() {
        String size = attributes.get(SIZE);
        if (size != null) {
            return new VideoSize(size);
        }
        return null;
    }

    @Override
    public void setVideoSize(VideoSize vsize) {
        attributes.put(SIZE, vsize.toString());
    }
}
