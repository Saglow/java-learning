package cn.saglow.java.exercise.day3;

import java.util.*;

/**
 * Description: 练习各类数据结构
 * Author: HW
 * Date: 2023/7/21
 */
//ArrayList：java.util.ArrayList 是动态数组实现的列表，可以动态地增加和减少元素。它提供了快速的随机访问和快速的尾部插入/删除操作。
//
//LinkedList：java.util.LinkedList 是链表实现的列表，可以在任意位置进行插入和删除操作。尽管随机访问较慢，但插入和删除操作非常高效。
//
//HashMap：java.util.HashMap 是基于哈希表实现的键值对映射，提供了快速的插入、删除和查找操作。它以键的哈希值为索引，因此具有较快的查找速度。
//
//HashSet：java.util.HashSet 是基于哈希表实现的集合，用于存储唯一的元素。它提供了快速的插入和删除操作，并可以快速检查元素是否存在。
//
//TreeSet：java.util.TreeSet 是基于红黑树实现的有序集合，它保持元素的排序状态，并提供了快速的插入、删除和查找操作。
//
//PriorityQueue：java.util.PriorityQueue 是优先级队列实现，用于按照优先级顺序处理元素。它通常用于解决优先级相关的问题，例如任务调度和事件处理。
//
//LinkedHashMap：java.util.LinkedHashMap 是哈希表与双向链表结合的数据结构，它保持元素的插入顺序，并提供了较快的查找速度。
//
//TreeMap：java.util.TreeMap 是基于红黑树实现的有序键值对映射，类似于 TreeSet，它保持键的排序状态，并提供了快速的插入、删除和查找操作。
//
//Stack：java.util.Stack 是栈的实现，用于实现后进先出（LIFO）的数据结构，提供了入栈、出栈和查看栈顶元素的操作。
//
//Queue：java.util.Queue 是队列的接口，提供了插入和移除元素的操作，常用的实现类有 LinkedList 和 PriorityQueue。
public class DataStructureTest {
    public static void main(String[] args) {
        //列表ArrayList
        ArrayList list1 = new ArrayList();
        list1.add("1");
        list1.add("2");
        System.out.println(list1);
        System.out.println(list1.get(1));
        list1.set(0,"3");
        System.out.println(list1);
        list1.add(2,"6");
        System.out.println(list1);
        list1.add(0,"8");
        System.out.println(list1);
        list1.clear();
        System.out.println(list1);
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("4");
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("3");
        list1.add("3");
        list1.add("9");
        System.out.println(list1);
        list1.remove("3");
        System.out.println(list1);
        System.out.println(list1.contains("4"));
        System.out.println(list1.indexOf("3"));
        System.out.println(list1.lastIndexOf("3"));
        System.out.println(list1.get(list1.size()-1));
        // TODO 是否存在更有效的写法求列表最后一个元素

        for(Iterator i=list1.iterator();i.hasNext();){
//            String number = (String)i.next();
//            System.out.println(number);
            System.out.println((String)i.next());
        }

        Iterator<String> iterator = list1.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
        }
        // TODO 几种写法优劣
        System.out.println("______________________________________________");
        //栈
        Stack stack = new Stack();
        System.out.println(stack.isEmpty());
        System.out.println(stack.empty());
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack.capacity());
        System.out.println(stack.firstElement());
        Iterator iterator2 = stack.iterator();
        while(iterator2.hasNext()){
            int i = (int) iterator2.next();
            System.out.println(i);
        }

        System.out.println("______________________________________________");

        //hashmap
        HashMap map = new HashMap(20,0.5f);
        //(初始容量,负载系数)
        map.put("c","唱");
        map.put("t","跳");
        map.put("r","rap");
        map.put("l","篮球");
        map.put("m","music");
        map.put("j","蔡徐坤");
        map.put("ji","蔡徐坤");
        map.remove("m");
        System.out.println(map);
        // todo hashmap的数据储存顺序
        System.out.println(map.size());
        System.out.println(map.containsValue("篮球"));
        System.out.println(map.containsKey("l"));
        System.out.println(map.get("r"));

        System.out.println("______________________________________________");

        //hashset
        HashSet set = new HashSet();
        set.add("rider");
        set.add("lancer");
        set.add("saber");
        set.add("archer");
        set.add("assassin");
        set.add("berserker");
        set.add("ruler");
        set.add("revenger");
        set.add("caster");
        System.out.println(set);
        System.out.println(set.contains("ruler"));
        set.remove("assassin");
        System.out.println(set.size());
    }
}
