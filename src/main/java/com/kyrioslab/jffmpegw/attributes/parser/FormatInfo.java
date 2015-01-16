package com.kyrioslab.jffmpegw.attributes.parser;

/**
 * Created by Ivan Kirilyuk on 16.01.15.
 *
 */
public class FormatInfo {

    private String filename;
    private String formatName;
    private String duration;
    private String size;

    public String getFormatName() {
        return formatName;
    }

    public void setFormatName(String formatName) {
        this.formatName = formatName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
