package cn.saglow.java.exercise.day3;
import java.io.File;
    /**
     * Description: 在给定路径下查找带有给定后缀的文件并打印到控制台
     * Author: HW
     * Date: 2023/7/21
     * @author HW
     */
public class SearchFile {
    public static void searchFile(File file, String suffix) {
        File[] files = file.listFiles();
        File[] filteredFiles = file.listFiles(((dir, name) -> name.endsWith(suffix)));

        if (filteredFiles != null) {
            for (int i = 0; i < filteredFiles.length; i++) {
                System.out.println(filteredFiles[i]);
            }
        }
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()) {
                    searchFile(files[i], suffix);
                }
            }
        }
    }

    public static void main(String[] args) {
        File file = new File("d:/workspace");
        searchFile(file, ".java");
    }
}
