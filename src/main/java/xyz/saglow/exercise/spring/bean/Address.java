package xyz.saglow.exercise.spring.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import xyz.saglow.exercise.spring.controller.MyMethodTree;
import xyz.saglow.exercise.spring.controller.TestDataStorage;
import xyz.saglow.exercise.spring.controller.DepthStorage;
import xyz.saglow.exercise.spring.controller.TreeStorage;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Author: HW
 * Date: 2023/8/6
 */
@Data
@AllArgsConstructor
public class Address {
    private String province;
    private String city;
    private String area;

    public void print() {

        String data = TestDataStorage.getData();

        System.out.println(Thread.currentThread() + " " +  data + " 居住在" + province + city + area);

    }

}
