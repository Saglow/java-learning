package cn.saglow.java.exercise.day8;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.URL;
import java.time.LocalDate;
import java.util.*;

/**
 * Description: 对象变map
 * Author: HW
 * Date: 2023/7/26
 */
public class ObjectToMap {

    // todo 练习代码， 不许自己写
    public static Map<String, Object> objectToMap(Object a) throws IllegalAccessException {

        Class clazz = a.getClass();
//        clazz.getAnnotation();
        Map<String, Object> map = new HashMap();
//        Field[] field = clazz.getFields();
        Field[] fields = clazz.getDeclaredFields();


        for (Field field : fields) {
            String str = field.getName();
            Object obj = field.get(a);
            map.put(str, obj);
        }
//        Method[] methods = clazz.getMethods();
//        for (Method field : methods) {
//            String str = field.getName();
//            Object obj = field.getDefaultValue(a);
//            map.put(str,obj);
//        }



        return map;
    }
    @Data
    @AllArgsConstructor
    @ToString
    @Builder
    public static class humanBeings{
        humanBeings(){

        }
        private BigDecimal height;
        private BigDecimal weight;

        @Format(prefix="2")
        private BigDecimal age;

        @Format(prefix="__")
        private String name;
    }

    public @interface Format {
        String prefix();

    }

    public static void main(String[] args) throws IllegalAccessException {
        humanBeings mango = new humanBeings(BigDecimal.valueOf(55),BigDecimal.valueOf(150),BigDecimal.valueOf(8),"Mofeng Cao");
        mango = humanBeings.builder()
                    .height(BigDecimal.ONE)
                    .weight(BigDecimal.TEN)
                    .name("mongo")
                    .build();
        List a = Arrays.asList(humanBeings.class.getFields());


//        a.clear();
//        a.addAll(ObjectToMap.class.getFields().);

        Collections.unmodifiableList(a);

        a.add("b"); // exception
        System.out.println(objectToMap(mango));
    }
}
