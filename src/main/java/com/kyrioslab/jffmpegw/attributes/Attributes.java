package com.kyrioslab.jffmpegw.attributes;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


public abstract class Attributes implements Serializable{
    /**
     * Aggregates common attributes. Format "key:value"
     */
    protected Map<String, String> attributes = new HashMap<String, String>();

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }
}
