package com.kyrioslab.jffmpegw.attributes.parser;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;
import com.kyrioslab.jffmpegw.command.Command;
import com.kyrioslab.jffmpegw.command.CommandExecutor;
import com.kyrioslab.jffmpegw.command.ProbeInfoCommand;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InfoParser {

    private static final Pattern ENCODER_DECODER_PATTERN = Pattern.compile(
            "^\\s(\\S+)\\s(\\S+)\\s+(\\S+).*", Pattern.CASE_INSENSITIVE);

    private static final String CODEC_FULL_VIDEO_SUPPORT = "DEV";
    private static final String CODEC_FULL_AUDIO_SUPPORT = "DEA";
    private static final String FORMAT_FULL_SUPPORT = "DE";

    public static MultimediaInfo getInfo(final String probeLocation, String filePath) throws IOException, InterruptedException {
        ProbeInfoCommand infoCommand =
                new ProbeInfoCommand(probeLocation, filePath);

        Process p = CommandExecutor.execute(infoCommand);
        if (p.waitFor() != 0) {
            throw new IllegalStateException("Process exited with code: "
                    + p.exitValue());
        }
        InputStream infoStream = p.getInputStream();
        MultimediaInfo multimediaInfo = new GsonBuilder()
                .setFieldNamingStrategy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create().fromJson(new InputStreamReader(infoStream),
                        MultimediaInfo.class);

        Command codecsInfoCommand = new Command() {
            @Override
            public List<String> getCommand() {
                return Arrays.asList(
                        probeLocation,
                        "-codecs",
                        "-v",
                        "quiet"
                );
            }
        };

        Process cp = CommandExecutor.execute(codecsInfoCommand);
        if (cp.waitFor() != 0) {
            throw new IllegalStateException("Process exited with code: "
                    + cp.exitValue());
        }

        Scanner cInfoScanner = new Scanner(cp.getInputStream());

        //move to start
        while (!cInfoScanner.nextLine().equals(" -------")) ;

        List<InfoItem> fullVideoSupportCodecList = new ArrayList<>();
        List<InfoItem> fullAudioSupportCodecList = new ArrayList<>();
        while (cInfoScanner.hasNextLine()) {
            String line = cInfoScanner.nextLine();
            Matcher matcher = ENCODER_DECODER_PATTERN.matcher(line);
            if (matcher.matches()) {
                String support = matcher.group(1);
                if (support.startsWith(CODEC_FULL_VIDEO_SUPPORT)) {
                    InfoItem videoCodecInfoItem = new InfoItem();
                    videoCodecInfoItem.setSupport(support);
                    videoCodecInfoItem.setName(matcher.group(2));
                    videoCodecInfoItem.setLongName(matcher.group(3));

                    fullVideoSupportCodecList.add(videoCodecInfoItem);
                } else if (support.startsWith(CODEC_FULL_AUDIO_SUPPORT)) {
                    InfoItem audioCodecInfoItem = new InfoItem();
                    audioCodecInfoItem.setSupport(support);
                    audioCodecInfoItem.setName(matcher.group(2));
                    audioCodecInfoItem.setLongName(matcher.group(3));

                    fullAudioSupportCodecList.add(audioCodecInfoItem);
                }
            }
        }

        multimediaInfo.setFullSupportedVideoCodecs(fullVideoSupportCodecList);
        multimediaInfo.setFullSupportedAudioCodecs(fullAudioSupportCodecList);

        Command formatInfoCommand = new Command() {
            @Override
            public List<String> getCommand() {
                return Arrays.asList(
                        probeLocation,
                        "-formats",
                        "-v",
                        "quiet"
                );
            }
        };

        Process fp = CommandExecutor.execute(formatInfoCommand);
        if (fp.waitFor() != 0) {
            throw new IllegalStateException("Process exited with code: "
                    + fp.exitValue());
        }

        Scanner fInfoScanner = new Scanner(fp.getInputStream());

        //move to start
        while (!fInfoScanner.nextLine().equals(" --")) {
        }

        List<InfoItem> formatFullSupportList = new ArrayList<>();
        while (fInfoScanner.hasNextLine()) {
            String line = fInfoScanner.nextLine();
            Matcher matcher = ENCODER_DECODER_PATTERN.matcher(line);
            if (matcher.matches()) {
                String support = matcher.group(1);
                if (support.startsWith(FORMAT_FULL_SUPPORT)) {
                    InfoItem item = new InfoItem();
                    item.setSupport(support);
                    item.setName(matcher.group(2));
                    item.setLongName(matcher.group(3));

                    formatFullSupportList.add(item);
                }
            }
        }
        multimediaInfo.setFullSupportedFormats(formatFullSupportList);
        return multimediaInfo;
    }

}
