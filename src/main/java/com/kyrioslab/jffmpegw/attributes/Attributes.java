package com.kyrioslab.jffmpegw.attributes;

import java.util.HashMap;
import java.util.Map;


public abstract class Attributes {
    /**
     * Aggregates common attributes with |attribute key:attribute value| format
     */
    protected Map<String, String> attributes = new HashMap<String, String>();

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }
}
