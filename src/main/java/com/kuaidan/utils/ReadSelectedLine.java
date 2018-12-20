package com.kuaidan.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReadSelectedLine {
    // 读取文件指定行。
    static void readAppointedLineNumber(File sourceFile, int lineNumber)
            throws IOException {
        FileReader in = new FileReader(sourceFile);
        LineNumberReader reader = new LineNumberReader(in);
        String s = "";
        if (lineNumber <= 0 || lineNumber > getTotalLines(sourceFile)) {
            System.out.println("不在文件的行数范围(1至总行数)之内。");
            System.exit(0);
        }
        int lines = 0;
        while (s != null) {
            lines++;
            s = reader.readLine();
            if((lines - lineNumber) == 0) {
                System.out.println(s);
                System.exit(0);
            }
        }
        reader.close();
        in.close();
    }
    static void readAppointedLineNumberNew(File sourceFile, int startNum,int endNum)
            throws IOException {
        FileReader in = new FileReader(sourceFile);
        LineNumberReader reader = new LineNumberReader(in);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("e:/dianzishu1.txt")));
        String s = "";
        if (startNum <= 0 || startNum > getTotalLines(sourceFile)) {
            System.out.println("不在文件的行数范围(1至总行数)之内。");
            System.exit(0);
        }
        if (endNum <= 0 || endNum > getTotalLines(sourceFile)) {
            System.out.println("不在文件的行数范围(1至总行数)之内。");
            System.exit(0);
        }
        if (startNum > endNum) {
            System.out.println("开始页不能大于结束页。");
            System.exit(0);
        }
        int lines = 0;
        while (s != null) {
            lines++;
            s = reader.readLine();
            if(lines >= startNum & lines <= endNum){
                System.out.println(s);
                bufferedWriter.write(s);
                bufferedWriter.newLine();
            }
            if(lines == endNum){
                break;
            }
        }
        reader.close();
        bufferedWriter.flush();
        bufferedWriter.close();
        in.close();
    }
    // 文件内容的总行数。
    static int getTotalLines(File file) throws IOException {
        FileReader in = new FileReader(file);
        LineNumberReader reader = new LineNumberReader(in);
        String s = reader.readLine();
        int lines = 0;
        while (s != null) {
            lines++;
            s = reader.readLine();
        }
        reader.close();
        in.close();
        return lines;
    }

    public static List<String> getTotalLinesList(List<String> list, File file) throws IOException {
        FileReader in = new FileReader(file);
        LineNumberReader reader = new LineNumberReader(in);
        String s = reader.readLine();
        while (s != null) {
            list.add(s);
            s = reader.readLine();
        }
        reader.close();
        in.close();
        return list;
    }

    public static List<String> readAppointedLineNumberNew(List<String> list,File sourceFile, int startNum,int endNum)
            throws IOException {
        FileReader in = new FileReader(sourceFile);
        LineNumberReader reader = new LineNumberReader(in);
        reader.setLineNumber(startNum);
//        for(int i=startNum;i<=endNum;i++){
//            list.add(reader.readLine());
//        }
        String s = "";
        int lines = 0;
        while (s != null) {
            lines++;
            s = reader.readLine();
            if(lines >= startNum & lines <= endNum){
                list.add(s);
            }
            if(lines == endNum){
                break;
            }
        }
        reader.close();
        in.close();
        return list;
    }

    public static int readCount(File sourceFile)
            throws IOException {
        FileReader in = new FileReader(sourceFile);
        LineNumberReader reader = new LineNumberReader(in);
        String s = "";
        int lines = 0;
        while (s != null) {
            lines++;
            s = reader.readLine();
        }
        reader.close();
        in.close();
        return lines;
    }
    public static List<String> readChapter(List<String>list,File sourceFile)
            throws IOException {
        FileReader in = new FileReader(sourceFile);
        LineNumberReader reader = new LineNumberReader(in);
        String s = "";
        while (s != null) {
            s = reader.readLine();
            if(s!=null && s.contains("------------")){
                for (int i = 0; i < 2 ; i++) {
                    s = reader.readLine();
                }
                list.add(s);
            }
        }
        reader.close();
        in.close();
        return list;
    }
    public static List<String> readChapterContent(List<String>list,File sourceFile,String chapter)
            throws IOException {
        FileReader in = new FileReader(sourceFile);
        LineNumberReader reader = new LineNumberReader(in);
        String s = "";
        while (s != null) {
            s = reader.readLine();
            if(s!=null && s.contains(chapter)){
                while(true){
                    list.add(s);
                    s = reader.readLine();
                    if(s!=null && s.contains("------------")){
                        //list.add(s);
                        //s = reader.readLine();
                        reader.readLine();
                        //list.add(s);
                        break;
                    }
                }
                break;
            }
        }
        reader.close();
        in.close();
        return list;
    }

    /**
     * 读取txt所有内容
     * @param list
     * @param sourceFile
     * @return
     * @throws IOException
     */
    public static List<Object> readAllContent(List<Object>list,File sourceFile)
            throws IOException {
        FileReader in = new FileReader(sourceFile);
        LineNumberReader reader = new LineNumberReader(in);
        String s = "";
        while (s != null) {
            s = reader.readLine();
            if(s != null){
                list.add(s);
            }
        }
        reader.close();
        in.close();
        return list;
    }

    public static List<String> readChapterContent(List<String> response,List<String> contentList,String chapter)
            throws IOException {
        contentList.stream().forEach(string ->{
            if(string.contains("------------")){
                List listChapterContent = new ArrayList();
                listChapterContent.add(string);
            }
            System.out.println(string);
        });

        return response;
    }
    public static Map<String,String> readChapter(Map<String,String> map,File sourceFile)
            throws IOException {
        FileReader in = new FileReader(sourceFile);
        LineNumberReader reader = new LineNumberReader(in);
        String s = "";
        Integer line = 0;
        while (s != null) {
            s = reader.readLine();
            line++;
            if(s!=null && s.contains("------------")){
                for (int i = 0; i < 2 ; i++) {
                    s = reader.readLine();
                    line++;
                }
                map.put(line.toString(), s);
            }
        }
        reader.close();
        in.close();
        return map;
    }

    public static void main(String[] args) throws IOException {
        //readChapter(new ArrayList<>(),new File("e:/all.txt"));
        readAllContent(new ArrayList<>(),new File("e:/all.txt"));
    }
    /**
     * 读取文件指定行。
     */
//    public static void main(String[] args) throws IOException {
//        // 指定读取的行号
//        int lineNumber = 2;
//        // 读取文件
//        File sourceFile = new File("e:/dianzishu.txt");
//        // 读取指定的行
//        //readAppointedLineNumber(sourceFile, lineNumber);
//        // 获取文件的内容的总行数
//        //System.out.println(getTotalLines(sourceFile));
//        readAppointedLineNumberNew(sourceFile, 1,5);
//    }
    public static File createFile(byte[] bfile) {
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        File file = null;
        try {
            file = new File("fastdfs.txt");
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(bfile);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return file;
    }

}
