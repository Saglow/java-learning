package cn.saglow.java.exercise.day15;

/**
 * Description:
 * Author: HW
 * Date: 2023/8/4
 * @author HW
 */
public class PasswordJudge {

    public static String passwordJudge(String str) {
        if (!getLegacy(str)) {
            return "invalid password";
        }
        switch (getStrength(str)) {
            case(1):
                return "weak password";
            case(2), (3):
                return "medium password";
            case(4):
                return "strong password";
            default:
                return "unknown wrong";
        }
    }

    private static Boolean getLegacy (String str){
        if (str.length() < 8 || str.length() > 16) {
            return false;
        }
        if (hasSameContinued(str)) {
            return false;
        }
        return true;
    }

    private static Integer getStrength (String str){
        Integer timer = 0 ;
        if (hasAlpha(str)) {
            timer++;
        }
        if (hasGreatAlpha(str)) {
            timer++;
        }
        if (hasNumber(str)) {
            timer++;
        }
        if (hasSign(str)) {
            timer++;
        }
        return timer;
    }

    private static boolean hasSameContinued(String str) {
        char[] ch = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            if (ch[i] >= 'A' && ch[i] <= 'Z') {
                ch[i] += 32;
            }
        }
        for (int i = 0; i < str.length() - 2; i++) {
            if (ch[i] == ch[i + 1] && ch[i] == ch[i + 2]) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasAlpha(String str) {
        char[] ch = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            if (ch[i] >= 'a' && ch[i] <= 'z') {
                return true;
            }
        }
        return false;
    }

    private static boolean hasGreatAlpha(String str) {
        char[] ch = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            if (ch[i] >= 'A' && ch[i] <= 'Z') {
                return true;
            }
        }
        return false;
    }

    private static boolean hasNumber(String str) {
        char[] ch = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            if (ch[i] >= '0' && ch[i] <= '9') {
                return true;
            }
        }
        return false;
    }

    private static boolean hasSign(String str) {
        char[] ch = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            if (ch[i] >= 33 && ch[i] <= 47) {
                return true;
            }
            if (ch[i] >= 58 && ch[i] <= 64) {
                return true;
            }
            if (ch[i] >= 91 && ch[i] <= 96) {
                return true;
            }
            if (ch[i] >= 123 && ch[i] <= 126) {
                return true;
            }
        }
        return false;
    }

}
