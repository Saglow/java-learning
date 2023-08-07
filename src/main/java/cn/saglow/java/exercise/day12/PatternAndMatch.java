package cn.saglow.java.exercise.day12;
import org.apache.commons.lang3.RegExUtils;

import java.util.regex.*;

/**
 * Description:
 * Author: HW
 * Date: 2023/7/31
 */
public class PatternAndMatch {
    public static void main(String[] args) {
//        RegExUtils
        String regex = "(\\{)|(})";
        String str = "hasefdiu{ah{asnfj}ns}snf}sfn{ty";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);

        StringBuffer result = new StringBuffer();
        while (matcher.find()) {
            String currentChar = matcher.group();
            if (currentChar.equals("{")) {
                matcher.appendReplacement(result, "}");
            } else if (currentChar.equals("}")) {
                matcher.appendReplacement(result, "{");
            }
        }
        matcher.appendTail(result);

        System.out.println(result);

    }

}
