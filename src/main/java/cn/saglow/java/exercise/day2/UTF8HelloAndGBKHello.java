package cn.saglow.java.exercise.day2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/**
 * Description: Utf8和GBK保存你好
 * Author: HW
 * Date: 2023/7/20
 */
public class UTF8HelloAndGBKHello {
    public static void main(String[] args) {
        resolveProblem();
//        String filePathU = "D:/workspace/temp/UTF_8.txt";
//        String filePathG = "D:/workspace/temp/GBK.txt";
//
//        File fileU = new File(filePathU);
//        try {
//            fileU.getParentFile().mkdirs();
//            fileU.createNewFile();
//        }catch(IOException e) {
//            e.printStackTrace();
//        }
//
//        File fileG = new File(filePathG);
//        try {
//            fileG.getParentFile().mkdirs();
//            fileG.createNewFile();
//        }catch(IOException e) {
//            e.printStackTrace();
//        }
//
// todo 代码带垃圾， 需要抽取公共方法

//        try {
//            OutputStream outputStream = new FileOutputStream(filePathU);
//            // 此时，outputStream 就是用来写入文件的流
//            outputStream.write("你好".getBytes(StandardCharsets.UTF_8));
//            outputStream.close(); // 关闭流
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            OutputStream outputStream = new FileOutputStream(filePathG);
//            // 此时，outputStream 就是用来写入文件的流
//            outputStream.write("你好".getBytes("GBK"));
//            outputStream.close(); // 关闭流
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
    private static void saveFile(String filePath, String fileContent) {
        saveFile("UTF-8",filePath,fileContent, false);
    }
    private static void saveFile(String charset, String filePath, String fileContent) {
        saveFile(charset,filePath,fileContent, false);
    }
    private static void saveFile(String charset, String filePath, String fileContent, Boolean append) {
        try (OutputStream outputStream = new FileOutputStream(filePath, append);){
            byte[] gbks = fileContent.getBytes(charset);
            outputStream.write(gbks);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void resolveProblem() {
        String filePathU = "D:/workspace/temp/UTF_8.txt";
        String filePathG = "D:/workspace/temp/GBK.txt";
        saveFile("UTF-8", filePathU, "你好");
        saveFile("GBK", filePathG, "你好");
    }
}
