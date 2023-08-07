package cn.saglow.java.exercise.day5;

import java.util.ArrayList;
import java.util.List;

import java.io.*;
import java.util.Scanner;

import static java.lang.Math.pow;

/**
 * Description: 简单习题合集
 * {@code @Author:} HW
 * Date: 2023/7/23
 */
public class ExerciseSet0 {
    public static int feiBoNaQi(int n){
        // todo 斐波那契
        int an;
        if (n==1||n==2){
            an = 1;
        }
        else{
            return feiBoNaQi(n-1)+ feiBoNaQi(n-2);
        }
        return an;
    }
    public static void shuiXianHua(){
        //todo 水仙花数
        for (int i = 100; i < 1000; i++) {
            int geWei = i % 10;
            int shiWei = i / 10 % 10;
            int baiWei = i / 100;
            if(pow(geWei,3)+pow(shiWei,3)+pow(baiWei,3)==i) {
                System.out.println(i);
            }
        }
    }

    public static List<Integer> fenJieZhiYinShu(int i){
        // todo 分解质因数
        List<Integer> list = new ArrayList<>();
        if (i == 1) {
            list.add(1);
            return list;
        }
        for (int j = 2; j <= i; j++) {
            if (i % j == 0) {
                i=i/j;
                list.add(j);
                j--;
            }
        }
        return list;
    }

    public static int zuiXiaoGongBeiShu(int a, int b) {
        //todo 最小公倍数
        List<Integer> list1 = fenJieZhiYinShu(a);
        List<Integer> list2 = fenJieZhiYinShu(b);
        List<Integer> list3 = new ArrayList<>();
        for(Integer iterator:list1){
            if(list2.contains(iterator)){
                list2.remove(iterator);
            }
            list3.add(iterator);
        }
        for(Integer iterator:list2){
            list3.add(iterator);
        }
        return list3.stream().reduce(1,(c,d)->c*d);
    }

    public static void tongJiZiFuChuan(String str){
        // todo 无法将连续的数字记为一个数字
        int daXieZiMu = 0;
        int xiaoXieZiMu = 0;
        int shuZi = 0;
        int kongGe = 0;
        int qiTaFuHao = 0;
        for(char c : str.toCharArray()){
            if (c >= 'A' && c <= 'Z') {
                daXieZiMu++;
            } else if (c >= 'a' && c <= 'z') {
                xiaoXieZiMu++;
            } else if (c >= '0' && c <= '9') {
                shuZi++;
            } else if (c == ' ') {
                kongGe++;
            } else {
                qiTaFuHao++;
            }
        }
        System.out.println("大写字母共"+daXieZiMu+"个");
        System.out.println("小写字母共"+xiaoXieZiMu+"个");
        System.out.println("数字共"+shuZi+"个");
        System.out.println("空格共"+kongGe+"个");
        System.out.println("其他字符共"+qiTaFuHao+"个");
    }

    public static void wanShu(){
        for (int i = 1; i <= 1000; i++) {
            int temp = 0;
            for (int j = 1; j <= i / 2; j++) {
                if (i % j == 0) {
                    temp = temp + j;
                }
            }
            if (temp == i) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(feiBoNaQi(10));
        System.out.println("________________________________________________");
        shuiXianHua();
        System.out.println("________________________________________________");
        System.out.println(fenJieZhiYinShu(1111));
        System.out.println("________________________________________________");
        System.out.println(zuiXiaoGongBeiShu(36,216));
        System.out.println("________________________________________________");
        tongJiZiFuChuan("你好，hello,  12,3,4,5,A,A,A");
        System.out.println("________________________________________________");
        wanShu();
    }
}
