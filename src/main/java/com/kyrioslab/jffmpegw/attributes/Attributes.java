package com.kyrioslab.jffmpegw.attributes;

import com.kyrioslab.jffmpegw.command.Command;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


public abstract class Attributes implements Serializable{

    private static final String DEFAULT_INDEX = "0:";

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

    public void setMap(int index) {
        attributes.put(Command.Attributes.Common.MAP,
                DEFAULT_INDEX + index);
    }
}
