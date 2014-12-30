package com.kyrioslab.jffmpegw.command;

import com.kyrioslab.jffmpegw.attributes.VideoSize;

import java.util.List;

/**
 * A Class represents FFMPEG command
 */
public interface Command {

    String FFMPEG_LOCATION = Command.class.getResource("/ffmpeg").getPath();

    /**
     * Standart FFMPEG command argument attributes
     */
    public interface Attributes {

        /**
         * FFMPEG common attributes
         */
        public interface Common {

            public static final String OFFSET = "-s";
            public static final String INPUT = "-i";
            public static final String DURATION = "-t";
            public static final String VIDEO_DISABLED = "-vn";
            public static final String AUDIO_DISABLED = "-an";
            public static final String FORMAT = "-f";
            public static final String SEGMENT = "segment";
            public static final String SEGMENT_TIME = "-segment_time";
            public static final String CODECS = "-c";
            public static final String CODEC_COPY = "copy";
            public static final String MAP = "-map";
            public static final String CONCAT = "concat";

            /**
             * Overwrite output files without asking
             */
            public static final String OWERRIDE = "-y";

            public String getOffset();

            public void setOffset(String offset);

            public String getInputFile();

            public void setInputFile(String inputFile);

            /**
             * Get duration in millis
             *
             * @return duration in millis
             */
            public long getDuration();

            /**
             * Set duration in millis
             *
             * @param duration in millis
             */
            public void setDuration(long duration);

            public boolean isVideoDisabled();

            public void disableVideo();

            public void enableVideo();

            public boolean isAudioDisabled();

            public void disableAudio();

            public void enableAudio();

            public String getFormat();

            public void setFormat(String format);

            public void setOwerride(boolean owerride);

            public boolean isOweride();
        }

        /**
         * FFMPEG video attributes
         */
        public interface Video {
            public static final String CODEC = "-vcodec";
            public static final String TAG = "-vtag";
            public static final String BIT_RATE = "-b";
            public static final String FRAME_RATE = "-r";
            public static final String SIZE = "-s";

            public String getCodec();

            public void setCodec(String codec);

            public String getTag();

            public void setTag(String tag);

            public String getBitRate();

            public void setBitRate(String bitRate);

            public double getFrameRate();

            public void setFrameRate(double frameRate);

            public VideoSize getVideoSize();

            public void setVideoSize(VideoSize vsize);
        }

        /**
         * FFMPEG audio attributes
         */
        public interface Audio {
            public static final String CODEC = "-acodec";
            public static final String BIT_RATE = "-ab";
            public static final String CHANNELS = "-ac";
            public static final String SAMPLING_RATE = "-ar";
            public static final String VOLUME = "-vol";

            public String getCodec();

            public void setCodec(String codec);

            public String getBitRate();

            public void setBitRate(String bitRate);

            public int getChannels();

            public void setChannels(int channelsCount);

            public int getSamplingRate();

            public void setSamplingRate(int samplingRate);

            public int getVolume();

            public void setVolume(int volume);
        }
    }

    public void addAttribute(String key);

    public void addAttribute(String key, String value);

    public List<String> getCommand();
}
