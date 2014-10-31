package com.jffmpegw;

import java.io.File;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class EncoderTest {

    String vidPath = this.getClass().getResource("/u4.mp4").getPath();
    FFMPEGLocator locator = new FFMPEGLocator() {
        @Override
        protected String getFFMPEGExecutablePath() {
            return "/home/wizzard/diploma_work/dsvc/ffmpeg/ffmpeg";
        }
    };

    @org.junit.Test
    public void testGetAudioDecoders() throws Exception {
        Encoder encoder = new Encoder(locator);
        String[] decoders = encoder.getAudioDecoders();
        for (String s : decoders) {
            System.out.println(s);
        }
        assertNotEquals(0, decoders.length);
    }

    @org.junit.Test
    public void testGetAudioEncoders() throws Exception {
        Encoder encoder = new Encoder(locator);
        String[] encoders = encoder.getAudioEncoders();
        for (String s : encoders) {
            System.out.println(s);
        }
        assertNotEquals(0, encoders.length);
    }

    @org.junit.Test
    public void testGetVideoDecoders() throws Exception {
        Encoder encoder = new Encoder(locator);
        String[] decoders = encoder.getVideoDecoders();
        for (String s : decoders) {
            System.out.println(s);
        }
        assertNotEquals(0, decoders.length);
    }

    @org.junit.Test
    public void testGetVideoEncoders() throws Exception {
        Encoder encoder = new Encoder(locator);
        String[] encoders = encoder.getVideoEncoders();
        for (String s : encoders) {
            System.out.println(s);
        }
        assertNotEquals(0, encoders.length);
    }

    @org.junit.Test
    public void testGetSupportedEncodingFormats() throws Exception {
        Encoder encoder = new Encoder(locator);
        String[] eformats = encoder.getSupportedEncodingFormats();
        for (String s : eformats) {
            System.out.println(s);
        }
        assertNotEquals(0, eformats.length);
    }

    @org.junit.Test
    public void testGetSupportedDecodingFormats() throws Exception {
        Encoder encoder = new Encoder(locator);
        String[] dformats = encoder.getSupportedDecodingFormats();
        for (String s : dformats) {
            System.out.println(s);
        }
        assertNotEquals(0, dformats.length);
    }

    @org.junit.Test
    public void testGetInfo() throws Exception {
        Encoder encoder = new Encoder(locator);
        MultimediaInfo info = encoder.getInfo(new File(vidPath));

        assertEquals(info.getFormat(), "mov");
        assertEquals(info.getDuration(), 834400);
        assertNotNull(info.getAudio());
        assertNotNull(info.getVideo());

        VideoInfo vi = info.getVideo();
        assertEquals(vi.getDecoder(), "h264");
        assertEquals(vi.getBitRate(), 146);
        assertEquals(vi.getFrameRate(), 15.0, 0.01);
        assertEquals(vi.getSize().getWidth(), 480);
        assertEquals(vi.getSize().getHeight(), 360);

        AudioInfo ai = info.getAudio();
        assertEquals(ai.getBitRate(), 96);
        assertEquals(ai.getChannels(), 2);
        assertEquals(ai.getDecoder(), "aac");
        assertEquals(ai.getSamplingRate(), 44100);
    }

    @org.junit.Test
    public void testEncode() throws Exception {
        Encoder encoder = new Encoder(locator);
        File source = new File(vidPath);
        File target = Paths.get(System.getProperty("java.io.tmpdir"),"testvid").toFile();
        EncodingAttributes attrs = new EncodingAttributes();
        VideoAttributes vattr = new VideoAttributes();
        vattr.setCodec("h263");
        vattr.setSize(new VideoSize(352,288));
        AudioAttributes audioAttributes = new AudioAttributes();
        audioAttributes.setCodec("copy");
        attrs.setFormat("3gp");
        attrs.setVideoAttributes(vattr);
        attrs.setAudioAttributes(audioAttributes);
        encoder.encode(source, target, attrs);
    }
}