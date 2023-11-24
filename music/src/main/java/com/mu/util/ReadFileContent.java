package com.mu.util;

import com.mu.entities.Album;
import com.mu.entities.Singer;
import com.mu.entities.SingerType;
import com.mu.entities.Song;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 读取本地文件内容
 */
public class ReadFileContent {
    /**
     * @return - 文件个数
     */
    private List<Singer> singers;

    public List<Singer> getSingers() {
        return singers;
    }

    public void setSingers(List<Singer> singers) {
        this.singers = singers;
    }

    public ReadFileContent() {
        singers = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "ReadFileContent{" +
                "singers=" + singers +
                '}';
    }

    /**
     * 读取歌曲内容
     *
     * @param path
     * @param songs
     */
    public void read4(String path, List<Song> songs) {//第四层，读取歌曲路径
        File file = new File(path);
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {//第四层 存储歌曲
            Song song = new Song();
            song.setSongTitle(ClipPath.clipFileName(files[i].getName()));
            String music = ClipPath.clip(files[i].getPath(), "music", ".");
            String[] split = music.split("/");
            StringBuffer buffer = new StringBuffer(); //拼装歌词路径
            for (int j = 1; j < split.length; j++) {
                if(j==4) {
                    buffer.append("/歌词");
                }
                else {
                    buffer.append("/"+split[j]);
                }
            }
            song.setLyric(buffer+".lrc");
            song.setSongUrl(ClipPath.clip(files[i].getPath(),"music"));
            songs.add(song);
        }
    }

    /**
     * 读取歌曲内容
     *
     * @param path
     * @param album
     */
    public void read3(String path, Album album) {//第三层，读取专辑内容及图片路径
        File file = new File(path);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {//第三层 存储歌曲
                if (files[i].isDirectory()) {//是文件
                    if(files[i].getName().equals("歌曲")) {
                        ArrayList<Song> songs = new ArrayList<>();
                        read4(files[i].getPath(), songs);
                        album.setSongs(songs);
                    }
                } else if (files[i].getName().equals("专辑资料.txt")) {
                    try {
                        String s = readFile(files[i].getPath());
                        String time = PatternUtil.Exc(s, "(?<=发行时间：)[\\s\\S]*(?=发行公司：)").trim();
                        String company = PatternUtil.Exc(s, "(?<=发行公司：)[\\s\\S]*(?=专辑介绍：)").trim();
                        String introduce = PatternUtil.Exc(s, "(?<=专辑介绍：)[\\s\\S]*").trim();
                        album.setTimeOfIssue(DateFormatUtil.getDate1(time));
                        album.setCompany(company);
                        album.setIntroduce(introduce);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    album.setImg(ClipPath.clip(files[i].getPath(),"music"));
                }
            }
        }
    }


    /**
     * 读取专辑信息
     *
     * @param path
     * @param singer
     */
    public void read2(String path, Singer singer) {
        File file = new File(path);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {//第一层 存储专辑
                if (files[i].isDirectory()) {//是文件,表示是专辑
                    Album album = new Album();//初始化专辑
                    album.setName(files[i].getName());//设置名字
                    read3(files[i].getPath(), album);
                    singer.getAlbums().add(album);
                    //System.out.println("序号：" + i + " " + files[i].getName());
                } else if (files[i].getName().equals("个人简介.txt")) {//个人简介
                    try {
                        String s = readFile(files[i].getPath());
                        String foreign_name = PatternUtil.Exc(s, "(?<=外文名：)[\\s\\S]*(?=别名：)").trim();
                        String alias = PatternUtil.Exc(s, "(?<=别名：)[\\s\\S]*(?=国籍：)").trim();
                        String nationality = PatternUtil.Exc(s, "(?<=国籍：)[\\s\\S]*(?=出生地：)").trim();
                        String birthplace = PatternUtil.Exc(s, "(?<=出生地：)[\\s\\S]*(?=生日：)").trim();
                        String birthday = PatternUtil.Exc(s, "(?<=生日：)[\\s\\S]*(?=职业：)").trim();
                        String occupation = PatternUtil.Exc(s, "(?<=职业：)[\\s\\S]*(?=代表作：)").trim();
                        String representative = PatternUtil.Exc(s, "(?<=代表作：)[\\s\\S]*(?=主要成就：)").trim();
                        String achievement = PatternUtil.Exc(s, "(?<=主要成就：)[\\s\\S]*(?=简介：)").trim();
                        String synopsis = PatternUtil.Exc(s, "(?<=简介：)[\\s\\S]*").trim();
                        singer.setAlias(alias);
                        singer.setForeignName(foreign_name);
                        singer.setNationality(nationality);
                        singer.setBirthplace(birthplace);
                        singer.setDateOfBirth(DateFormatUtil.getDate(birthday));
                        singer.setOccupation(occupation);
                        singer.setRepresentative(representative);
                        singer.setAchievement(achievement);
                        singer.setSynopsis(synopsis);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    singer.setHeadPortrait(ClipPath.clip(files[i].getPath(),"music"));
                }
            }
        }
    }


    /**
     * @param path
     */
    public void read1(String path) {
        File file = new File(path);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {//第一层 存储歌手id,和名字
                if (files[i].isDirectory()) {
                    String s = files[i].getName();
                    Singer singer = new Singer();//初始化歌手
                    singer.setAlbums(new ArrayList<>());//创建专辑列表
                    SingerType singerType = new SingerType();
                    singerType.setTypeId(1);
                    singer.setSingerType(singerType);
                    singer.setName(s);//保存名字
                    //System.out.println("序号：" + i + " " + files[i].getName());
                    read2(files[i].getPath(), singer);//进入单个歌手的专辑录入
                    singers.add(singer);//将歌手存入到集合中
                }
            }
        }
        //System.out.println(singers);
    }

    public int getFile(String path) {//获取文件数量
        int count = 0;
        File file = new File(path);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File file1 : files) {
                if (file1.isDirectory()) {
                    count += getFile(file1.getPath());
                } else {
                    System.out.println(file1.getPath());
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * @param path - 文件路径
     * @return - 文件内容
     * @throws IOException
     **/
    public static String readFile(String path) throws IOException {
        File file = new File(path);
        if (file.isDirectory()||!file.exists())
            return "";//如果是一个文件夹就返回空
        FileInputStream inputStream = new FileInputStream(file);
        InputStreamReader reader = new InputStreamReader(inputStream, "UTF-8");//将字节流转换成字符，我们用我们能理解的utf-8来进行编码
        StringBuffer buffer = new StringBuffer();
        while (reader.ready()) {
            buffer.append((char) reader.read());
        }
        reader.close();
        inputStream.close();
        return buffer.toString();
    }


    /**
     * 字节流的读取
     * @param path
     * @return
     * @throws IOException
     */
    public byte[] readFileStream(String path) throws IOException {
        File file = new File(path);
        if (!file.exists())
            return null;
        FileInputStream inputStream = new FileInputStream(file);
        byte[] b = new byte[inputStream.available()];
        inputStream.read(b);
        inputStream.close();
        System.out.println("文件读取成功");
        return b;
    }

    public void writeFileStream(String path,byte[] bytes) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        }
        OutputStream outputStream = new FileOutputStream(file, true);
        outputStream.write(bytes);
        outputStream.close();
        System.out.println("文件成功写完-------");
    }

    public void writeFile(String path, String content) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        }
        OutputStream outputStream = new FileOutputStream(file, true);
        OutputStreamWriter writer = new OutputStreamWriter(outputStream, "UTF-8");
        writer.append("\n");
        writer.append(content);
        writer.close();
        outputStream.close();
        System.out.println("文件成功写完-------");
    }

    /**
     * 删除文件
     *
     * @param path
     * @throws IOException
     **/
    public void deleteFile(String path) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            System.out.println("该文件已不存在----");
            return;
        }
        file.delete();
        System.out.println("删除成功");
    }

    public static void main(String[] args) throws Exception {
        /*String path1 = "D:/static/music";
        ReadFileContent readFileContent = new ReadFileContent();
        readFileContent.read1(path1);*/
        String path = "D:/static/music/2/1/lyric/2sa1as1.lrc";
        System.out.println(readFile(path));
    }
}

class ClipPath{

    public static String clipNo(String path,String start,String end){
        return  path.substring(path.indexOf(start)-1,path.indexOf(end));
    }

    public static String clipNo(String path,String start){
        return  path.substring(path.indexOf(start)-1);
    }

    public static String clip(String path,String start,String end){
        String s = path.replaceAll("\\\\", "/");
        return  s.substring(s.indexOf(start)-1,s.indexOf(end));
    }

    /**
     *
     * @param path - 路径
     * @param start - 路径截取的开始位置
     * @return
     */
    public static String clip(String path,String start){
        String s = path.replaceAll("\\\\", "/");
        return s.substring(s.indexOf(start)-1);
    }

    /**
     * 去掉后缀
     * @param fileName
     * @return
     */
    public static String clipFileName(String fileName){
        return fileName.substring(0,fileName.indexOf("."));
    }
}
