package cn.saglow.java.exercise.day2;
import java.io.*;

/**
 * Description: 合并两个txt
 * Author: HW
 * Date: 2023/7/20
 */
public class TwoTxtToOneTxt {
    public static void main(String[] args) {
        String inputFilePath1 = "d:/workspace/temp/1.txt";
        String inputFilePath2 = "d:/workspace/temp/2.txt";
        String outputFilePath = "d:/workspace/temp/3.txt";
        // todo
        try (InputStream inputStream1 = new FileInputStream(inputFilePath1);
             InputStream inputStream2 = new FileInputStream(inputFilePath2);
             OutputStream outputStream = new FileOutputStream(outputFilePath)) {

            // 读取第一个输入文件并写入输出文件
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream1.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            // 读取第二个输入文件并写入输出文件
            while ((bytesRead = inputStream2.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            System.out.println("合并完成！");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
