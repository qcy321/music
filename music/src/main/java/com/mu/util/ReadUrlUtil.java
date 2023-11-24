package com.mu.util;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class ReadUrlUtil {

    public static final String ipPath = "http://localhost/static/"; //服务器地址

    public static String read(String urlPath) throws Exception {
        URL url = new URL(ipPath + urlPath);
        URLConnection urlConnection = url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        InputStreamReader reader = new InputStreamReader(inputStream, "UTF-8");
        StringBuffer stringBuffer = new StringBuffer();
        while (reader.ready()) {
            stringBuffer.append((char) reader.read());
        }
        reader.close();
        inputStream.close();
        return stringBuffer.toString();
    }

    /*public static void main(String[] args) {
        try {
            ReadUrlUtil.read("/static/music/2/10/lyric/2sa10as41.lrc");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}
