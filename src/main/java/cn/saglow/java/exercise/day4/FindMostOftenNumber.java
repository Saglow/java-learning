package cn.saglow.java.exercise.day4;

import java.util.*;

/**
 * Description: 找出数组中最频繁出现的数字
 * Author: HW
 * Date: 2023/7/22
 */
public class FindMostOftenNumber {
    public static Set findMostOftenNumber(int[] numbers) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        arrayToMap(numbers,map);
        Set answerSet = new HashSet();
        entrySort(map, answerSet);
        return answerSet;
    }

    public static void arrayToMap(int[] numbers, HashMap<Integer, Integer> map) {
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                map.put(numbers[i], map.get(numbers[i]) + 1);
            } else {
                map.put(numbers[i], 1);
            }
        }
    }

    public static void entrySort(HashMap<Integer, Integer> map , Set answerSet){
        List<Map.Entry<Integer, Integer>> list = new ArrayList();
        list.addAll(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue()-o2.getValue();
            }
        });
        answerSet.add(list.get(list.size()-1).getKey());
        for(int i = list.size()-2 ; i >-1 ; i-- ){
            if(list.get(i).getValue().equals(list.get(i+1).getValue())){
                answerSet.add(list.get(i).getKey());
            }
            else{
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1,1,1,3,3,4,4,5,5,5,6,6,7,7,8,8,8};
        Set set = findMostOftenNumber(array);
        System.out.println(set);
    }

}
