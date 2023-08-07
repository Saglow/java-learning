package xyz.saglow.exercise.spring.controller;

/**
 * Description:
 * Author: HW
 * Date: 2023/8/6
 */
public class TestDataStorage {
    private static ThreadLocal<String> tl = new ThreadLocal<>();

    public static void setData(String data) {
        tl.set(data);
    }

    public static String getData() {
        return tl.get();
    }
    public static void remove() {
        tl.remove();
    }
}
