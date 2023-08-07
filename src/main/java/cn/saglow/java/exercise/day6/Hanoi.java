package cn.saglow.java.exercise.day6;

/**
 * Description: 汉诺塔
 * Author: HW
 * Date: 2023/7/24
 */
public class Hanoi {
    public static void printHanoiStep(String source, String target, String temp, Integer depth) {
        if(depth == 1){
            System.out.println("Move 1 from "+source+" to "+target);
            return;
            //一开始写了个无限递归，值得反思
        }
        printHanoiStep(source,temp,target,depth-1);
        System.out.println("Move " + depth + " from " + source + " to " + target);
        printHanoiStep(temp,target,source,depth-1);
    }

    public static void main(String[] args) {
        String source = "A";
        String temp = "B";
        String target = "C";
        int depth = 2;
        printHanoiStep(source, target, temp, depth);
    }
}
