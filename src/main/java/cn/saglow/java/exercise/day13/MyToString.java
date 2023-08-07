package cn.saglow.java.exercise.day13;

import lombok.AllArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.lang.reflect.Field;

/**
 * Description:
 * Author: HW
 * Date: 2023/8/1
 */
public class MyToString {
    public static String myToString(Object obj) throws IllegalAccessException {
        StringBuilder stringBuilder = new StringBuilder();
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            stringBuilder.append(field.getName()+" = ");
            stringBuilder.append(field.get(obj)+"\n");
        }
        return stringBuilder.toString();
        // todo 学习下
//        ToStringBuilder.reflectionToString(obj);
    }

    public static void main(String[] args) throws IllegalAccessException {
        Test cmf = new Test(99,100,'A',true);
        System.out.println(myToString(cmf));
    }
    @AllArgsConstructor
    static
    class Test{
        private Integer chinese;
        private Integer math;
        private char english;
        private Boolean isPassed;
    }
}
