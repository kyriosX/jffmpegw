package com.kyrioslab.jffmpegw.attributes.parser;

import java.io.Serializable;

/**
 * Created by Ivan Kirilyuk on 17.01.15.
 *
 */
public class TagsInfo implements Serializable {

    private String language;

    public TagsInfo() {
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
