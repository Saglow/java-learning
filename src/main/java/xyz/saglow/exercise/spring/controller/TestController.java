package xyz.saglow.exercise.spring.controller;

import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import xyz.saglow.exercise.spring.bean.Address;
import xyz.saglow.exercise.spring.bean.Person;
import xyz.saglow.exercise.spring.controller.DepthStorage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Description:
 * Author: HW
 * Date: 2023/8/3
 */
@RestController
public class TestController {

    @GetMapping("/test/get")
    public Person createRandomPerson() {
        String data = TestDataStorage.getData();
        System.out.println(Thread.currentThread() + " " +data);
        return Person.builder()
                .name("cango")
                .age(new Random().nextInt(100))
                .address("shanghai")
                .build();
    }

    @PostMapping("/test/post")
    public Person createRandomPerson2(@RequestBody Person param) throws InterruptedException {
        TestDataStorage.setData(param.getName());
        Person p = Person.builder()
                .name(param.getName())
                .age(new Random().nextInt(100))
                .address("shanghai")
                .build();
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
        p.print();
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

//        new Thread(() -> {
//            Address a = new Address("上海2","上海2","浦东新区2");
//            a.print();
//            // todo 如何获取父线程所有的threadlocal，给到子线程
//        }).start();
//        Thread.sleep(10);
//        TestDataStorage.remove();
        return p;
    }
}
