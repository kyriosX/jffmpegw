package com.kyrioslab.jffmpegw.command;

import com.kyrioslab.jffmpegw.attributes.parser.StreamInfo;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class CommandBuilderTest {

    @Test
    public void testBuild() throws Exception, BuilderException {

        StreamInfo vs = new StreamInfo();
        vs.setCodecType("video");
        vs.setCodecName("mpeg4");
        vs.setAvgFrameRate("15/1");
        vs.setBitRate("124999");
        vs.setHeight("420");
        vs.setWidth("360");
        vs.setIndex(0);

        StreamInfo as = new StreamInfo();
        as.setCodecType("audio");
        as.setCodecName("aac");
        as.setBitRate("63999");
        as.setSampleRate("36000");
        as.setIndex(1);
        as.setChannels("2");

        EncodeCommandBuilder builder = new EncodeCommandBuilder("testloc",
                Arrays.asList(vs,as));
        Command command = builder.build();

        System.out.println(command.getCommand());
    }
}