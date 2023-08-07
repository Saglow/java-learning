package cn.saglow.java.exercise.day2;
import java.io.*;
import java.nio.charset.StandardCharsets;


/**
 * Description: 保存文件
 * Author: HW
 * Date: 2023/7/20
 */
public class SaveFile {
    public static void main(String[] args) {
        String filePath = "D:/workspace/temp/1.txt";
        File file = new File(filePath);

            File path = file.getParentFile();
            if(!path.exists()) {
                path.mkdirs();
            }
//            file.createNewFile();
//        try {
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(filePath);
            // 此时，outputStream 就是用来写入文件的流
            outputStream.write("Hello world".getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(outputStream != null) {
                    outputStream.close(); // 关闭流
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void saveFile2(String fileName, String content) {
        File file = new File(fileName);
        try (OutputStream outputStream = new FileOutputStream(file);
             OutputStream outputStream1 = new FileOutputStream(file);
             OutputStream outputStream2 = new FileOutputStream(file);
             OutputStream outputStream3 = new FileOutputStream(file);
             OutputStream outputStream4 = new FileOutputStream(file);
        ) {
            // 此时，outputStream 就是用来写入文件的流
            outputStream.write("Hello world".getBytes(StandardCharsets.UTF_8));
            //
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
