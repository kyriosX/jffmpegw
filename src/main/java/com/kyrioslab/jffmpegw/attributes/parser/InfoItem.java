package com.kyrioslab.jffmpegw.attributes.parser;

/**
 * Created by Ivan Kirilyuk on 10.01.15.
 *
 */
public class InfoItem {

    private String support;
    private String name;
    private String longName;

    public InfoItem() {}

    public String getSupport() {
        return support;
    }

    public void setSupport(String support) {
        this.support = support;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

}
