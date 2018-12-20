package com.kuaidan.utils;

import java.io.File;
import java.io.RandomAccessFile;

public class CountLine {
    /*
     * 读取文件绝对路径
     */
    private static String filePath = "e:/aaaa.txt";

    public static void main(String[] args) {

        long line = readLine(filePath);

        System.out.println(line);

    }

    /**
     * 读取文件行数
     *
     * @param path
     *            文件路径
     * @return long
     */
    public static int readLine(String path) {
        int index = 0;
        try {
            RandomAccessFile file = new RandomAccessFile(new File(path), "r");
            while (null != file.readLine()) {
                index++;
            }
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return index;
    }

    public static int readLine(File file) {
        int index = 0;
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
            while (null != randomAccessFile.readLine()) {
                index++;
            }
            randomAccessFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return index;
    }
}
