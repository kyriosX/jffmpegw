package com.kyrioslab.jffmpegw.command;

import org.junit.Test;

import static org.junit.Assert.*;

public class CommandBuilderTest {

    @Test
    public void testBuild() throws Exception, BuilderException {
        EncodeCommandBuilder builder = new EncodeCommandBuilder("testloc");
        Command command = builder.disableAudio()
                .enableVideo()
                .setAudioBitRate("4000k")
                .setAudioCodec("mp3")
                .setChannels(7)
                .setFrameRate(15)
                .setVolume(10)
                .setDuration(400).build();
        System.out.println(command.getCommand());
    }
}