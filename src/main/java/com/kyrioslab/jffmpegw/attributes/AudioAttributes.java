package com.kyrioslab.jffmpegw.attributes;

import com.kyrioslab.jffmpegw.command.Command;

public class AudioAttributes extends Attributes implements Command.Attributes.Audio{

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
    public int getChannels() {
        return Integer.parseInt(attributes.get(CHANNELS));
    }

    @Override
    public void setChannels(int channelsCount) {
        attributes.put(CHANNELS, String.valueOf(channelsCount));
    }

    @Override
    public int getSamplingRate() {
        return Integer.parseInt(attributes.get(SAMPLING_RATE));
    }

    @Override
    public void setSamplingRate(int samplingRate) {
        attributes.put(SAMPLING_RATE, String.valueOf(samplingRate));
    }

    @Override
    public int getVolume() {
        return Integer.parseInt(attributes.get(VOLUME));
    }

    @Override
    public void setVolume(int volume) {
        attributes.put(VOLUME, String.valueOf(volume));
    }
}
