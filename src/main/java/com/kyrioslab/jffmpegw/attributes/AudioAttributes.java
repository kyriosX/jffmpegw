package com.kyrioslab.jffmpegw.attributes;

import com.kyrioslab.jffmpegw.command.Command;

public class AudioAttributes extends Attributes implements Command.Attributes.Audio{

    public AudioAttributes() {

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
    public String getBitRate() {
        return attributes.get(BIT_RATE);
    }

    @Override
    public void setBitRate(String bitRate) {
        attributes.put(BIT_RATE, bitRate);
    }

    @Override
    public String getChannels() {
        return attributes.get(CHANNELS);
    }

    @Override
    public void setChannels(String channelsCount) {
        attributes.put(CHANNELS, channelsCount);
    }

    @Override
    public String getSamplingRate() {
        return attributes.get(SAMPLING_RATE);
    }

    @Override
    public void setSamplingRate(String samplingRate) {
        attributes.put(SAMPLING_RATE, samplingRate);
    }

    @Override
    public String getVolume() {
        return attributes.get(VOLUME);
    }

    @Override
    public void setVolume(String volume) {
        attributes.put(VOLUME, volume);
    }
}
