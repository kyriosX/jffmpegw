package com.kyrioslab.jffmpegw.attributes.parser;

import org.junit.Test;

import static org.junit.Assert.*;

public class InfoParserTest {

    @Test
    public void testGetInfo() throws Exception {
        MultimediaInfo info = InfoParser.getInfo("/home/wizzard/diploma_work/dsvc/ffmpeg/ffprobe",
                this.getClass().getResource("/u4.mp4").getPath());
        assertNotNull(info);
    }
}