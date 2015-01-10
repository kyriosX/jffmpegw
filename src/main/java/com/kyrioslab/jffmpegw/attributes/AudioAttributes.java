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
    public int getChannels() {
        String channels = attributes.get(CHANNELS);
        if (channels != null) {
            return Integer.parseInt(channels);
        }
        return -1;
    }

    @Override
    public void setChannels(int channelsCount) {
        attributes.put(CHANNELS, String.valueOf(channelsCount));
    }

    @Override
    public int getSamplingRate() {
        String samplingRate = attributes.get(SAMPLING_RATE);
        if (samplingRate != null) {
            return Integer.parseInt(samplingRate);
        }
        return -1;
    }

    @Override
    public void setSamplingRate(int samplingRate) {
        attributes.put(SAMPLING_RATE, String.valueOf(samplingRate));
    }

    @Override
    public int getVolume() {
        String volume = attributes.get(VOLUME);
        if (volume != null) {
            return Integer.parseInt(volume);
        }
        return -1;
    }

    @Override
    public void setVolume(int volume) {
        attributes.put(VOLUME, String.valueOf(volume));
    }
}
