package com.kyrioslab.jffmpegw.command;

import com.kyrioslab.jffmpegw.attributes.VideoSize;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

public class CommandExecutorTest {

    @Test
    public void testExecute() throws Exception, BuilderException {
        String ffmpeg = this.getClass().getResource("/ffmpeg").getPath();
        Command command = new EncodeCommandBuilder(ffmpeg)
                .enableAudio()
                .enableVideo()
                .setInputFile(this.getClass().getResource("/u4.mp4").getPath())
                .setDuration(83440)
                .setVideoCodec("h264")
                .setVideoBitRate("146")
                .setFrameRate(4)
                .setVideoSize(new VideoSize(200, 100))
                .setAudioBitRate("64")
                .setChannels(1)
                .setAudioCodec("aac")
                .setAudioSamplingRate(44100)
                .setTarget(Paths.get(System.getProperty("java.io.tmpdir"), "testvid.mp4").toAbsolutePath().toString())
                .build();


        Process p = CommandExecutor.execute(command);
        p.waitFor();
        assertEquals(0, p.exitValue());
    }
}