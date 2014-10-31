package com.jffmpegw.utils;

/**
 * Created by Ivan Kirilyuk on 31.10.14.
 *
 * Helper class for Encoder
 */
public class Util {

    private static final String DECODING_SUPPORTED = "D";
    private static final String ENCODING_SUPPORTED = "E";
    private static final String VIDEO_CODEC = "V";
    private static final String AUDIO_CODEC = "A";

    public static boolean isEncodingSupport(String info) {
        return info.contains(ENCODING_SUPPORTED);
    }

    public static boolean isDecodiongSupport(String info) {
        return info.contains(DECODING_SUPPORTED);
    }

    public static boolean isVideoCodec(String info) {
        return info.contains(VIDEO_CODEC);
    }

    public static boolean isAudioCodec(String info) {
        return info.contains(AUDIO_CODEC);
    }

}
