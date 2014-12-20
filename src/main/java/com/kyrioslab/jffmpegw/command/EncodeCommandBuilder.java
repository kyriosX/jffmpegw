package com.kyrioslab.jffmpegw.command;

import com.kyrioslab.jffmpegw.attributes.AudioAttributes;
import com.kyrioslab.jffmpegw.attributes.CommonAttributes;
import com.kyrioslab.jffmpegw.attributes.VideoAttributes;
import com.kyrioslab.jffmpegw.attributes.VideoSize;

public class EncodeCommandBuilder extends CommandBuilder {

    public EncodeCommandBuilder(String FFMPEGLocation) throws BuilderException {
        if (FFMPEGLocation == null) {
            throw new BuilderException("FFMPEG location not set");
        }
        command = new EncodeCommand();
        command.addAttribute(FFMPEGLocation);
    }

    public EncodeCommandBuilder(String FFMPEGLocation, CommonAttributes ca, VideoAttributes va,
                                AudioAttributes aa) throws BuilderException {
        this(FFMPEGLocation);
        commonAttributes = ca;
        videoAttributes = va;
        audioAttributes = aa;
    }

    public EncodeCommandBuilder setOffset(String offset) {
        commonAttributes.setOffset(offset);
        return this;
    }

    public EncodeCommandBuilder setInputFile(String inputFile) {
        commonAttributes.setInputFile(inputFile);
        return this;
    }

    /**
     * Set duration in seconds
     *
     * @param duration in seconds
     */
    public EncodeCommandBuilder setDuration(int duration) {
        commonAttributes.setDuration(duration);
        return this;
    }

    public EncodeCommandBuilder disableVideo() {
        commonAttributes.disableVideo();
        return this;
    }

    public EncodeCommandBuilder enableVideo() {
        commonAttributes.enableVideo();
        return this;
    }

    public EncodeCommandBuilder disableAudio() {
        commonAttributes.disableAudio();
        return this;
    }

    public EncodeCommandBuilder enableAudio() {
        commonAttributes.enableAudio();
        return this;
    }

    public EncodeCommandBuilder setFormat(String format) {
        commonAttributes.setFormat(format);
        return this;
    }

    public EncodeCommandBuilder setOwerride(boolean owerride) {
        commonAttributes.setOwerride(owerride);
        return this;
    }

    public EncodeCommandBuilder setVideoCodec(String codec){
        videoAttributes.setCodec(codec);
        return this;
    }

    public EncodeCommandBuilder seVideotTag(String tag){
        videoAttributes.setTag(tag);
        return this;
    }

    public EncodeCommandBuilder setVideoBitRate(String bitRate){
        videoAttributes.setBitRate(bitRate);
        return this;
    }

    public EncodeCommandBuilder setFrameRate(double frameRate){
        videoAttributes.setFrameRate(frameRate);
        return this;
    }

    public EncodeCommandBuilder setVideoSize(VideoSize vsize){
        videoAttributes.setVideoSize(vsize);
        return this;
    }

    public EncodeCommandBuilder setAudioCodec(String codec) {
        audioAttributes.setCodec(codec);
        return this;
    }

    public EncodeCommandBuilder setAudioBitRate(String bitRate){
        audioAttributes.setBitRate(bitRate);
        return this;
    }

    public EncodeCommandBuilder setChannels(int channelsCount){
        audioAttributes.setChannels(channelsCount);
        return this;
    }

    public EncodeCommandBuilder setAudioSamplingRate(int samplingRate){
        audioAttributes.setSamplingRate(samplingRate);
        return this;
    }

    public EncodeCommandBuilder setVolume(int volume){
        audioAttributes.setVolume(volume);
        return this;
    }

    public EncodeCommandBuilder setTarget(String absPath) {
        command.addAttribute(absPath);
        return this;
    }
}
