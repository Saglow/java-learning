package cn.saglow.java.exercise.day15;

import static cn.saglow.java.exercise.day15.PasswordJudge.passwordJudge;

/**
 * Description:
 * Author: HW
 * Date: 2023/8/4
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(passwordJudge("asgvbedfiyuagsbhpiudefhbna"));
        System.out.println(passwordJudge("asgvbedfiyu"));
        System.out.println(passwordJudge("asg67829b&BBNsba"));
        System.out.println(passwordJudge("AaAbortion86"));
    }
}
