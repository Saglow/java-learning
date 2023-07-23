package cn.saglow.java.exercise.day5;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Description: 获得出现次数大于Frequency的字符串
 * Author: HW
 * Date: 2023/7/23
 */
public class GetCountMoreThanFrequency {
    public static List<String> getCountMoreThanFrequency(List<Set<String>> content, Integer frequency) {
        return content.stream()
                .flatMap(Set::stream)
                .toList()
                .stream()
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(i->i.getValue()>frequency)
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue))
                .keySet()
                .stream()
                .toList();
    }

    public static void main(String[] args) {
        List<Set<String>> list = new ArrayList<>();
        Set<String> set = Set.of("A","B","C");
        Set<String> set1 = Set.of("A","B","C","D");
        Set<String> set2= Set.of("A","B","C","D","E");
        Set<String> set3 = Set.of("A","B","C","D","E","F");
        Set<String> set4 = Set.of("A","B","C","D","E","F","G");
        Set<String> set5 = Set.of("A","B","C","D","E","F","G","H");
        list.add(set);
        list.add(set1);
        list.add(set2);
        list.add(set3);
        list.add(set4);
        list.add(set5);
        System.out.println(list);
        System.out.println(getCountMoreThanFrequency(list,3));
    }
}
