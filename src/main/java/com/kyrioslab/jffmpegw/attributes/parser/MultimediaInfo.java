package com.kyrioslab.jffmpegw.attributes.parser;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Ivan Kirilyuk on 10.01.15.
 *
 */
public class MultimediaInfo implements Serializable{

    private List<StreamInfo> streams;
    private List<InfoItem> fullSupportedAudioCodecs;
    private List<InfoItem> fullSupportedVideoCodecs;
    private List<InfoItem> fullSupportedFormats;

    public MultimediaInfo() {}

    public List<StreamInfo> getStreams() {
        return streams;
    }

    public void setStreams(List<StreamInfo> streams) {
        this.streams = streams;
    }

    public List<InfoItem> getFullSupportedFormats() {
        return fullSupportedFormats;
    }

    public void setFullSupportedFormats(List<InfoItem> fullSupportedFormats) {
        this.fullSupportedFormats = fullSupportedFormats;
    }

    public List<InfoItem> getFullSupportedAudioCodecs() {
        return fullSupportedAudioCodecs;
    }

    public void setFullSupportedAudioCodecs(List<InfoItem> fullSupportedAudioCodecs) {
        this.fullSupportedAudioCodecs = fullSupportedAudioCodecs;
    }

    public List<InfoItem> getFullSupportedVideoCodecs() {
        return fullSupportedVideoCodecs;
    }

    public void setFullSupportedVideoCodecs(List<InfoItem> fullSupportedVideoCodecs) {
        this.fullSupportedVideoCodecs = fullSupportedVideoCodecs;
    }
}
