package cn.saglow.java.exercise.day2;

import static java.lang.Math.pow;

/**
 * Description: 三进制和十进制互相转换
 * Author: HW
 * Date: 2023/7/20
 * @author HW
 */
public class TransBetweenTriAndTen {
    public static int triToTen(int trinumber){
        //三进制转十进制
        int tennumber = 0;
        for (int i = 0; trinumber != 0; i++) {
            tennumber += trinumber % 10 * pow(3, i);
            trinumber /= 10;
        }
        return tennumber;
    }
    public static int tenToTri(int tennumber){
        //十进制转三进制
        int trinumber = 0;
        for (int i = 0; tennumber != 0; i++) {
            trinumber += tennumber % 3 * pow(10, i);
            tennumber /= 3;
        }
        return trinumber;
    }
    // TODO 两个方法高度相似，可以思考合并为一种
    // TODO 处理浮点型
    public static void main(String[] args) {
        int tri = -12;
        int ten = 10;
        System.out.println(triToTen(tri));
        System.out.println(tenToTri(ten));
    }
}
