package com.mu.util;

import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.Tag;

import java.io.File;

public class ReadMP3DurationUtil {

    public static String getDuration(File file) throws Exception {
        Integer duration = null;
        MP3File mp3File = (MP3File) AudioFileIO.read(file);
        AudioHeader audioHeader = mp3File.getAudioHeader();
        Tag tag = mp3File.getID3v2TagAsv24();
        if (tag != null) {
            duration = audioHeader.getTrackLength();
        }
        Integer minute = duration / 60;
        Integer second = duration % 60;
        return (String.valueOf(minute).length() == 2 ? String.valueOf(minute) : ("0" + minute)) + ":" + (String.valueOf(second).length() == 2 ? String.valueOf(second) : ("0" + second));
    }
}
