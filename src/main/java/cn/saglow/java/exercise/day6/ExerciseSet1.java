package cn.saglow.java.exercise.day6;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

/**
 * Description: 练习合集
 * Author: HW
 * Date: 2023/7/24
 */
public class ExerciseSet1 {
    public static BigDecimal bonusByInterest(){
        System.out.println("请输入利润数");
        Scanner scanner = new Scanner(System.in);
        BigDecimal interest = new BigDecimal(String.valueOf(scanner.next()));
        if (interest.compareTo(BigDecimal.valueOf(100000)) <= 0) {
            return interest.multiply(BigDecimal.valueOf(0.1))
                    .setScale(2, RoundingMode.HALF_UP);
        }else if(interest.compareTo(BigDecimal.valueOf(200000))<=0){
            return interest.subtract(BigDecimal.valueOf(100000))
                    .multiply(BigDecimal.valueOf(0.075))
                    .add(BigDecimal.valueOf(100000*0.1))
                    .setScale(2,RoundingMode.HALF_UP);
        }else if(interest.compareTo(BigDecimal.valueOf(400000))<=0){
            return interest.subtract(BigDecimal.valueOf(200000))
                    .multiply(BigDecimal.valueOf(0.05))
                    .add(BigDecimal.valueOf(100000*0.1+100000*0.075))
                    .setScale(2,RoundingMode.HALF_UP);
        }else if(interest.compareTo(BigDecimal.valueOf(600000))<=0){
            return interest.subtract(BigDecimal.valueOf(400000))
                    .multiply(BigDecimal.valueOf(0.03))
                    .add(BigDecimal.valueOf(100000*0.1+100000*0.075+200000*0.05))
                    .setScale(2,RoundingMode.HALF_UP);
        } else if (interest.compareTo(BigDecimal.valueOf(1000000)) <= 0) {
            return interest.subtract(BigDecimal.valueOf(600000))
                    .multiply(BigDecimal.valueOf(0.015))
                    .add(BigDecimal.valueOf(100000*0.1+100000*0.075+200000*0.05+200000*0.03))
                    .setScale(2,RoundingMode.HALF_UP);
        } else {
            return interest.subtract(BigDecimal.valueOf(1000000))
                    .multiply(BigDecimal.valueOf(0.01))
                    .add(BigDecimal.valueOf(100000*0.1+100000*0.075+200000*0.05+200000*0.03+400000*0.015))
                    .setScale(2,RoundingMode.HALF_UP);
        }
    }

    public static void getDayofTheYear(int year,int month,int day){
        LocalDate oneDay = LocalDate.of(year, month, day);
        System.out.println(oneDay.getDayOfYear());
    }
    public static int[] sortInt(int[] a){
        return Arrays.stream(a).sorted().toArray();
    }

    public static long factorialOfN(long i){
        if(i<0||i>20){
            return -1;
        }
        if(i==1||i==0){
            return 1;
        }
        return i*factorialOfN(i-1);
    }

    public static long daoShu(long i) {
        if (((i % 10) == 0 && i != 0) || i < 0) {
            return -1;
        }
        long sum = 0;
        while (i != 0) {
            sum = sum * 10 + i % 10;
            i = i / 10;
        }
        return sum;
    }
    public static boolean huiWenShu(int i) {
        if (i / 10000 == i % 10 && i / 1000 % 10 == i % 100 / 10) {
            return true;
        }
        return false;
    }

    public static void niXuShuChu(int[] a){
        int[] b = new int[a.length];
        for (int i = a.length - 1; i >= 0; i--) {
            b[a.length - 1 - i] = a[i];
        }
        System.out.println(Arrays.toString(b));
    }

    public static void yangHuiSanJiao(int n) {
        for (int i = 1; i <= n; i++) {
            for (int k = 1; k <= n - i; k++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(factorialOfN(i-1)/factorialOfN(j-1)/factorialOfN(i-j)+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println(bonusByInterest());
        System.out.println("_________________________________________");
        getDayofTheYear(2078,3,28);
        System.out.println("_________________________________________");
        int[] a = {3,4,12,12,35,6,68,98,43,5,34,56,8,7,9,567};
        System.out.println(Arrays.toString(sortInt(a)));
        System.out.println("_________________________________________");
        System.out.println(factorialOfN(20));
        System.out.println("_________________________________________");

        long sum = 0;
        for (long i = 1; i <= 20; i++) {
            sum+=factorialOfN(i);
        }
        System.out.println(sum);

        System.out.println("_________________________________________");
        System.out.println(daoShu(3034));
        System.out.println("_________________________________________");
        System.out.println(huiWenShu(78987));
        System.out.println("_________________________________________");

        int[] array ={1,2,3,32,42,35,4,75,780,7,45,2,3,42,2,12,3};
        niXuShuChu(array);

        System.out.println("_________________________________________");

        yangHuiSanJiao(10);
    }
}
