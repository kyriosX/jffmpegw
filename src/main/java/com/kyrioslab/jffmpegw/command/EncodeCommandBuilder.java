package com.kyrioslab.jffmpegw.command;

import com.google.common.base.Strings;
import com.kyrioslab.jffmpegw.attributes.Attributes;
import com.kyrioslab.jffmpegw.attributes.AudioAttributes;
import com.kyrioslab.jffmpegw.attributes.VideoAttributes;
import com.kyrioslab.jffmpegw.attributes.parser.StreamInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EncodeCommandBuilder {

    private static final String CODEC_TYPE_VIDEO = "video";
    private static final String CODEC_TYPE_AUDIO = "audio";

    protected List<Attributes> skel = new ArrayList<>();

    protected EncodeCommand command;

    public EncodeCommandBuilder(String FFMPEGLocation, Iterable<StreamInfo> streams) throws BuilderException {
        if (FFMPEGLocation == null) {
            throw new BuilderException("FFMPEG location not set");
        }
        command = new EncodeCommand();
        command.addAttribute(FFMPEGLocation);

        //set input as undefined
        command.setInput("");
        addStreams(streams);
    }

    /**
     * Add stream attributes to command.
     *
     * @param stream stream info
     * @throws BuilderException
     */
    public void addStream(StreamInfo stream) throws BuilderException {
        switch (stream.getCodecType()) {
            case CODEC_TYPE_VIDEO: {
                VideoAttributes va = new VideoAttributes();
                va.setMap(stream.getIndex());

                String codecName = stream.getCodecName();
                String bitRate = stream.getBitRate();
                String frameRate = stream.getAvgFrameRate();
                String width = stream.getWidth();
                String height = stream.getHeight();
                String aspectRatio = stream.getDisplayAspectRatio();
                String pixelFormat = stream.getPixFmt();

                if (!Strings.isNullOrEmpty(codecName)) {
                    va.setCodec(codecName);
                }
                if (!Strings.isNullOrEmpty(bitRate)) {
                    va.setBitRate(bitRate);
                }
                if (!Strings.isNullOrEmpty(frameRate)) {
                    va.setFrameRate(frameRate);
                }
                if (!Strings.isNullOrEmpty(width) &&
                        !Strings.isNullOrEmpty(height)) {
                    va.setVideoSize(width + "x" + height);
                }
                if (!Strings.isNullOrEmpty(aspectRatio)) {
                    va.setAspectRatio(aspectRatio);
                }
                if (!Strings.isNullOrEmpty(pixelFormat)) {
                    va.setPixelFormat(pixelFormat);
                }
                if (stream.isDisabled()) {
                    va.setDisabled();
                }
                skel.add(va);
            }
            break;
            case CODEC_TYPE_AUDIO: {
                AudioAttributes aa = new AudioAttributes();
                aa.setMap(stream.getIndex());

                String codecName = stream.getCodecName();
                String bitRate = stream.getBitRate();
                String channels = stream.getChannels();
                String sampleRate = stream.getSampleRate();
                String volume  = stream.getVolume();

                if (!Strings.isNullOrEmpty(codecName)) {
                    aa.setCodec(codecName);
                }
                if (!Strings.isNullOrEmpty(bitRate)) {
                    aa.setBitRate(bitRate);
                }
                if (!Strings.isNullOrEmpty(channels)) {
                    aa.setChannels(channels);
                }
                if (!Strings.isNullOrEmpty(sampleRate)) {
                    aa.setSamplingRate(sampleRate);
                }
                if (!Strings.isNullOrEmpty(volume)) {
                    aa.setVolume(volume);
                }
                if (stream.isDisabled()) {
                    aa.setDisabled();
                }
                skel.add(aa);
            }
            break;
            default:
                throw new BuilderException("Unknown codec type: " + stream.getCodecType());
        }
    }

    /**
     * Add stream configurations to command.
     *
     * @param streams stream list
     * @throws BuilderException
     */
    public void addStreams(Iterable<StreamInfo> streams) throws BuilderException {
        for (StreamInfo stream : streams) {
            addStream(stream);
        }
    }

    public EncodeCommand build() {
        for (Attributes attributes : skel) {
            addAttributes(attributes);
        }
        return command;
    }

    private void addAttributes(Attributes attributes) {
        Map<String, String> amap = attributes.getAttributes();

        //place map first
        if (amap.containsKey(Command.Attributes.Common.MAP)) {
            command.addAttribute(Command.Attributes.Common.MAP,
                    amap.remove(Command.Attributes.Common.MAP));
        }

        //add attributes
        for (Map.Entry<String, String> atrr : attributes.getAttributes().entrySet()) {
            String val = atrr.getValue();
            if (!Strings.isNullOrEmpty(val)) {
                command.addAttribute(atrr.getKey(), val);
            } else {
                command.addAttribute(atrr.getKey());
            }
        }
    }
}
