package cn.saglow.java.exercise.day8;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: 对象变map
 * Author: HW
 * Date: 2023/7/26
 */
public class ObjectToMap {
    public static Map<String, Object> objectToMap(Object a) throws IllegalAccessException {

        Class clazz = a.getClass();
        Map<String, Object> map = new HashMap();
//        Field[] field = clazz.getFields();
        Field[] field = clazz.getDeclaredFields();

        for (Field iterator : field) {


            String str = iterator.getName();
            Object obj = iterator.get(a);
            map.put(str, obj);
        }
//        Method[] methods = clazz.getMethods();
//        for (Method iterator : methods) {
//            String str = iterator.getName();
//            Object obj = iterator.getDefaultValue(a);
//            map.put(str,obj);
//        }
        return map;
    }
    @Data
    @AllArgsConstructor
    public static class humanBeings{
        private BigDecimal height;
        public BigDecimal weight;
        private BigDecimal age;
        private String name;
    }

    public static void main(String[] args) throws IllegalAccessException {
        humanBeings mango = new humanBeings(BigDecimal.valueOf(55),BigDecimal.valueOf(150),BigDecimal.valueOf(8),"Mofeng Cao");
        System.out.println(objectToMap(mango));
    }
}
