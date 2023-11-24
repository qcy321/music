package com.mu.test;

import java.io.File;

public class FileTest {
    public static void main(String[] args) {
        File file = new File("D:\\static\\User\\head");
        for (File listFile : file.listFiles()) {
            System.out.println(listFile.getName());
        }
    }
}
