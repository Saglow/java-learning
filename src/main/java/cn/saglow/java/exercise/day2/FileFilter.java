package cn.saglow.java.exercise.day2;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Description: 文件过滤
 * Author: HW
 * Date: 2023/7/20
 */
public class FileFilter {
    public static void listFile(String targetDir) {
        listFile(new File(targetDir));
    }
    // 查询目录和子目录下所有的文件
    public static void listFile(File targetFile) {
        if(targetFile.isDirectory() && targetFile.exists()) {
            File[] files = targetFile.listFiles();
            for(int i =0; i < files.length; i++) {
                System.out.println(files[i]);
                listFile(files[i]);
            }
        } else {
            System.out.println("这个是一个文件");
        }
    }

    public static void listAndFilter(File targetDir, String suffix) {
        FilenameFilter filenameFilter = new A(suffix);
        targetDir.listFiles(filenameFilter);
    }


    public static void listAndFilter2(File targetDir, String suffix) {
        targetDir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(suffix);
            }
        });
    }

    public static void listAndFilter3(File targetDir, String suffix) {
        targetDir.listFiles((dir, name) -> name.endsWith(suffix));
    }

    public static class A implements FilenameFilter {
        private String suffix;

        public A(String suffix) {
            this.suffix = suffix;
        }

        @Override
        public boolean accept(File dir, String name) {

            return name.endsWith(suffix);
        }
    }
}
