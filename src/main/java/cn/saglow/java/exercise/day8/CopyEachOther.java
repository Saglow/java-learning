package cn.saglow.java.exercise.day8;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.reflect.Field;

/**
 * Description: 互相copy
 * Author: HW
 * Date: 2023/7/26
 */
public class CopyEachOther {
    // todo 练习代码， 不需要自己写
    public static void copyEachOther(lancer source, mage target){



    }
    @AllArgsConstructor
    @Data
    public static class lancer{
        private String weapon;
        private Integer health;
        private Integer armor;
    }

    @Data
    @AllArgsConstructor
    public static class mage {
        private String weapon;
        private Integer health;
        private Integer mana;
    }

    public static void main(String[] args) throws IllegalAccessException {
        lancer lancer = new lancer("lance", 12, 10);
        mage mage = new mage("magic wand",6,20);
        copyEachOther(lancer, mage);
        System.out.println(lancer);
        System.out.println(mage);
    }
}
