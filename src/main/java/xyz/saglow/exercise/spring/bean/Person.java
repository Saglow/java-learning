package xyz.saglow.exercise.spring.bean;

import cn.saglow.java.exercise.day10.builderTest.Test;
import lombok.Builder;
import lombok.Data;
import xyz.saglow.exercise.spring.controller.DepthStorage;
import xyz.saglow.exercise.spring.controller.TestDataStorage;

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

        a.print();

    }
    public void print2(String name) {
        System.out.println(Thread.currentThread() + " " + name + " say \"hello world\"");
    }
}
