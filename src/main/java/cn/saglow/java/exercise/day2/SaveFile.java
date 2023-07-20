package cn.saglow.java.exercise.day2;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.io.File;


/**
 * Description: 保存文件
 * Author: HW
 * Date: 2023/7/20
 */
public class SaveFile {
    public static void main(String[] args) {
        String filePath = "D:/workspace/temp/1.txt";
        File file = new File(filePath);
        try {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }catch(IOException e) {
            e.printStackTrace();
        }

        try {
            OutputStream outputStream = new FileOutputStream(filePath);
            // 此时，outputStream 就是用来写入文件的流
            outputStream.write("Hello world".getBytes(StandardCharsets.UTF_8));
            outputStream.close(); // 关闭流
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
