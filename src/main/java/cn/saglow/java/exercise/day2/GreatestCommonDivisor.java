package cn.saglow.java.exercise.day2;

/**
 * Description: 最大公约数
 * Author: HW
 * Date: 2023/7/20
 */
public class GreatestCommonDivisor {
    public static int greatestCommonDivisor(int x,int y) {
        if (x<y) {
            int temp=x;
            x = y;
            y = temp;
        }
        return zhanzhuanxiangchu(x, y);
    }
    private static int zhanzhuanxiangchu(int x, int y) {
        //辗转相除
        if (y == 0) {
            return x;
        }
        return zhanzhuanxiangchu(y, x%y);
    }

    public static void main(String[] args) {
        System.out.println(greatestCommonDivisor(24,32));
    }
}
