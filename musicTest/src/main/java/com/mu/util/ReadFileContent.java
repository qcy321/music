package com.mu.util;


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
    /*private List<Singer> singers;

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

    *//**
     * @param path - 歌手地址
     *//*
    public void insertOneSinger(String path, Singer singer) {
        File file = new File(path);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {//第一层 存储专辑
                if (files[i].isDirectory()) {
                    Album album = new Album();//初始化专辑
                    album.setName(files[i].getName());//设置名字
                    album.setSingerId(singer.getSingerId());//设置外键歌手id
                    singer.getAlbums().add(album);
                    System.out.println("序号：" + i + " " + files[i].getName());
                }
                else{//个人简介
                    try {
                        String s = readFile(files[i].getPath());
                        String alias = PatternUtil.Exc(s, "(?<=外文名：)[\\s\\S]*(?=别名：)").trim();
                        String foreign_name = PatternUtil.Exc(s, "(?<=别名：)[\\s\\S]*(?=国籍：)").trim();
                        String nationality = PatternUtil.Exc(s, "(?<=国籍：)[\\s\\S]*(?=出生地：)").trim();
                        String birthplace = PatternUtil.Exc(s, "(?<=出生地：)[\\s\\S]*(?=生日：)").trim();
                        String birthday = PatternUtil.Exc(s, "(?<=生日：)[\\s\\S]*(?=职业：)").trim();
                        String occupation = PatternUtil.Exc(s, "(?<=职业：)[\\s\\S]*(?=代表作：)").trim();
                        String daibiaozuo = PatternUtil.Exc(s, "(?<=代表作：)[\\s\\S]*(?=主要成就：)").trim();
                        String achievement = PatternUtil.Exc(s, "(?<=主要成就：)[\\s\\S]*").trim();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    *//**
     * @param path - 音乐地址
     *//*
    public void insert(String path) {
        File file = new File(path);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {//第一层 存储歌手id,和名字
                if (files[i].isDirectory()) {
                    String[] s = files[i].getName().split("_");
                    Singer singer = new Singer();//初始化歌手
                    singer.setAlbums(new ArrayList<>());//创建专辑列表
                    singer.setSingerId(Integer.parseInt(s[0]));//保存id号
                    singer.setName(s[1]);//保存名字

                    System.out.println("序号：" + i + " " + files[i].getName());

                    insertOneSinger(files[i].getPath(), singer);//进入单个歌手的专辑录入
                    singers.add(singer);//将歌手存入到集合中
                }
            }
        }
    }

    public int getFile(String path) {
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

    *//**
     * @param path - 文件路径
     * @return - 文件内容
     * @throws IOException
     *//*
    public String readFile(String path) throws IOException {
        File file = new File(path);
        if (file.isDirectory())
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

    public byte[] readFileStream(String path) throws IOException {
        File file = new File(path);
        FileInputStream inputStream = new FileInputStream(file);
        byte[] b = new byte[inputStream.available()];
        inputStream.read(b);
        inputStream.close();
        return b;
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

    *//**
     * 删除文件
     *
     * @param path
     * @throws IOException
     *//*
    public void deleteFile(String path) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            System.out.println("该文件已不存在----");
            return;
        }
        file.delete();
        System.out.println("删除成功");
    }

    public static void main(String[] args) throws IOException {
        String path = "D:\\音乐\\1001_许嵩\\个人简介.txt";
        String path1 = "D:\\音乐";
        ReadFileContent readFileContent = new ReadFileContent();
        readFileContent.insert(path1);
        //System.out.println(readFileContent.getFile(path1));
        // System.out.println(readFileContent.readFile(path));
        *//*try {
            System.out.println(readFileContent.readFile(path));
            System.out.println("文件正常运行——————————————————————————————");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件读取失败---------------------");
        }*//*
       *//* byte[] c = readFileContent.readFileStream(path);
        for (byte b : c) {
            System.out.println(b+" ");
        }*//*
        //System.out.println(readFileContent.getFile(path));

        *//*String content = "这里是我的资料";
        readFileContent.writeFile(path1,content);
        System.out.println(readFileContent.readFile(path1));*//*
    }*/
}
