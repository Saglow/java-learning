package cn.saglow.java.exercise.day8;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Description: map转化为对象
 * Author: HW
 * Date: 2023/7/26
 */
public class MapToObject {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Map<String , Object> map = new HashMap<>();
        map.put("height",BigDecimal.valueOf(168));
        map.put("weight",BigDecimal.valueOf(150));
        map.put("weight1",BigDecimal.valueOf(150));
        map.put("name","Yuhui Fang");
        map.put("age", BigDecimal.valueOf(22));
        System.out.println(mapToObject(map,ObjectToMap.humanBeings.class));
    }
    public static <T>T mapToObject(Map<String , Object> map, Class<T> clazz) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        T bean = clazz.getDeclaredConstructor().newInstance();
        for (String key : map.keySet()) {
            Object value = map.get(key);
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String str = entry.getKey();
            Object obj = entry.getValue();
            String methodName = "set" + str.substring(0,1).toUpperCase(Locale.ROOT)+str.substring(1);
            Method setterMethod = clazz.getMethod(methodName, obj.getClass());
            setterMethod.invoke(bean, obj);

        }

        for (Field field : clazz.getDeclaredFields()) {
            String fieldName = field.getName();
            if (map.containsKey(fieldName)) {
                // todo
            }
        }
        return bean;
    }
}
