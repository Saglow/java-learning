package xyz.saglow.exercise.spring.bean;

import cn.saglow.java.exercise.day10.builderTest.Test;
import lombok.Builder;
import lombok.Data;
import xyz.saglow.exercise.spring.controller.DepthStorage;
import xyz.saglow.exercise.spring.controller.MyMethodTree;
import xyz.saglow.exercise.spring.controller.TestDataStorage;
import xyz.saglow.exercise.spring.controller.TreeStorage;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Author: HW
 * Date: 2023/8/3
 */

@Data
@Builder
public class Person {
    private String name;
    private Integer age;
    private String address;

    public void print() {
        String data = TestDataStorage.getData();
        System.out.println(Thread.currentThread() + " " + "the threadlocal data is : " + data);
        Address a = new Address("上海","上海","浦东新区");

//        {
//            MyMethodTree<String,Long,Long> currentNode = TreeStorage.getTree();
//            if (currentNode.isRoot()) {
//                currentNode.setValue("%s");
//                currentNode.setStartTime(System.currentTimeMillis());
//                TreeStorage.setTree(currentNode);
//            } else {
//                MyMethodTree<String,Long,Long> newNode = new MyMethodTree<>("%s",System.currentTimeMillis());
//                currentNode.addChild(newNode);
//                TreeStorage.setTree(newNode);
//            }
//        }
        a.print();
//        {
//            MyMethodTree<String,Long,Long> currentNode = TreeStorage.getTree();
//            currentNode.setEndTime(System.currentTimeMillis());
//            if (currentNode.isRoot()) {
//                List<MyMethodTree<String,Long,Long>> list = new ArrayList<>();
//                list.add(currentNode);
//                MyMethodTree.print(list);
//            } else {
//                TreeStorage.setTree(currentNode.getParent());
//            }
//        }

    }
    public void print2(String name) {
        System.out.println(Thread.currentThread() + " " + name + " say \"hello world\"");
    }
}
