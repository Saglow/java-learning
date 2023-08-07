package cn.saglow.java.exercise.day3;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Description: 文件编码读取
 * Author: HW
 * Date: 2023/7/21
 */
public class ReadFileWithCharset {
    // TODO 一行太长了，应当写得更好看
    public static void SaveWithCharset1ReadWithCharset2(String charset1,String charset2,String fileName,String content) throws IOException {
        File file = new File(fileName);
        FileOutputStream os = new FileOutputStream(file);
        FileInputStream is = new FileInputStream(file);
        os.write(content.getBytes(charset1));

        System.out.println(new String(is.readAllBytes(),charset2));
    }

    public static void main(String[] args) throws IOException {
        SaveWithCharset1ReadWithCharset2("UTF-8","GBK","d:/workspace/temp/UTF_8.txt","你好");
        SaveWithCharset1ReadWithCharset2("GBK","UTF-8","d:/workspace/temp/GBK.txt","你好");
    }
}
