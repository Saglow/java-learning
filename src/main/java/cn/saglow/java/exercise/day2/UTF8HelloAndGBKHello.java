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
        String filePathU = "D:/workspace/temp/UTF_8.txt";
        String filePathG = "D:/workspace/temp/GBK.txt";

        File fileU = new File(filePathU);
        try {
            fileU.getParentFile().mkdirs();
            fileU.createNewFile();
        }catch(IOException e) {
            e.printStackTrace();
        }

        File fileG = new File(filePathG);
        try {
            fileG.getParentFile().mkdirs();
            fileG.createNewFile();
        }catch(IOException e) {
            e.printStackTrace();
        }


        try {
            OutputStream outputStream = new FileOutputStream(filePathU);
            // 此时，outputStream 就是用来写入文件的流
            outputStream.write("你好".getBytes(StandardCharsets.UTF_8));
            outputStream.close(); // 关闭流
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            OutputStream outputStream = new FileOutputStream(filePathG);
            // 此时，outputStream 就是用来写入文件的流
            outputStream.write("你好".getBytes("GBK"));
            outputStream.close(); // 关闭流
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
