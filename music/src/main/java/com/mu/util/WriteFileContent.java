package com.mu.util;

import com.mu.entities.Album;
import com.mu.entities.Singer;
import com.mu.entities.Song;

import java.io.*;
import java.util.List;

public class WriteFileContent {


    public void rename3(String path, List<Song> songs, Album album, Integer id, String mainPath) throws IOException {
        if (album.getImg() != null) {
            String newUrl = ReadWrite.newUrl(path, album.getImg(), album.getAlbumId(), mainPath);
            album.setImg(newUrl);
        }
        File file = new File(path + "\\song");
        File file2 = new File(path + "\\lyric");
        if (!file.exists()) {
            file.mkdir();
        }
        if (!file2.exists()) {
            file2.mkdir();
        }
        for (Song song : songs) {
            if (song.getSongUrl() != null) {
                String newUrl = ReadWrite.newUrl(path, song.getSongUrl(), id, album.getAlbumId(), song.getSongId(), "song", mainPath);
                song.setSongUrl(newUrl);
            }
            if (song.getLyric() != null) {
                String newUrl = ReadWrite.newUrl(path, song.getLyric(), id, album.getAlbumId(), song.getSongId(), "lyric", mainPath);
                song.setLyric(newUrl);
            }
        }
    }

    /**
     * 写入专辑层
     *
     * @param path
     * @param albums
     * @param singer
     * @throws IOException
     */
    public void rename2(String path, List<Album> albums, Singer singer, String mainPath) throws IOException {
        if (singer.getHeadPortrait() != null) {//头像文件的迁移，以及文件名编码
            String newUrl = ReadWrite.newUrl(path, singer.getHeadPortrait(), singer.getSingerId(), mainPath);
            singer.setHeadPortrait(newUrl);
        }
        for (Album album : albums) {
            File file1 = new File(path + "\\" + album.getAlbumId());
            if (!file1.exists()) {
                file1.mkdir();
            }
            System.out.println("开始进入第三层");
            rename3(file1.getPath(), album.getSongs(), album, singer.getSingerId(), mainPath);
        }
    }

    /**
     * 写如歌手层
     *
     * @param path
     * @param singers
     * @throws IOException
     */
    public void rename1(String path, List<Singer> singers) throws IOException {
        File file = new File(path);//音乐文件夹的创建
        if (!file.exists()) {
            file.mkdir();
        }
        for (Singer singer : singers) {
            File file1 = new File(path + "\\" + singer.getSingerId());//以歌手id创建歌手目录文件夹
            if (!file1.exists()) {
                file1.mkdir();
            }
            rename2(file1.getPath(), singer.getAlbums(), singer, file.getName());
        }
    }
}

class ReadWrite {

    public static final ReadFileContent readFileContent = new ReadFileContent();

    public static final String PREFIX_PATH = "D:\\static";

    public static final String LOCALHOST_PATH = "http://localhost/static";

    /**
     * @param path     - 主要路径
     * @param oldUrl   - 旧地址
     * @param id       - id
     * @param mainPath - 主目录名
     * @return
     * @throws IOException
     */
    public static String newUrl(String path, String oldUrl, Integer id, String mainPath) throws IOException {
        System.out.print(oldUrl);
        byte[] bytes = readFileContent.readFileStream(PREFIX_PATH + oldUrl);//读取原路径地址
        String suffix = oldUrl.substring(oldUrl.lastIndexOf("."));//获取后缀名
        String writePath = path + "\\" + id + suffix;//路径组装
        readFileContent.writeFileStream(writePath, bytes);//写入新路径地址
        return LOCALHOST_PATH + ClipPath.clip(writePath, mainPath);
    }

    /**
     * @param path     - 当前路径
     * @param oldUrl   - 文件旧地址
     * @param id1      - 歌手id
     * @param id2      - 专辑id
     * @param id3      - 歌曲id
     * @param type     - 歌词还是歌曲
     * @param mainPath - 主目录名
     * @return - 新路径
     * @throws IOException
     */
    public static String newUrl(String path, String oldUrl, Integer id1, Integer id2, Integer id3, String type, String mainPath) throws IOException {
        System.out.println(oldUrl);
        byte[] bytes = readFileContent.readFileStream(PREFIX_PATH + oldUrl);//读取歌曲/歌词
        String suffix = oldUrl.substring(oldUrl.lastIndexOf("."));//获取后缀名
        String encode = EncodeFileNameUtil.encode(id1, id2, id3) + suffix;//编码
        String writePath = path + "\\" + type + "\\" + encode;//路径组装
        readFileContent.writeFileStream(writePath, bytes);//写入歌曲/歌词
        return LOCALHOST_PATH + ClipPath.clip(writePath, mainPath);
    }
}
