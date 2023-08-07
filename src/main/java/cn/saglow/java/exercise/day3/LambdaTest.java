package cn.saglow.java.exercise.day3;

import javax.sound.midi.Soundbank;

/**
 * Description: 测试lambda表达式
 * Author: HW
 * Date: 2023/7/21
 */
public class LambdaTest {
    class innerClass {
        String str = "有啥用呢";
        innerClass(){
            System.out.println(str);
        }
        void go(){
            System.out.println("go");
        }
    }

    static String run() {
        return "1";
    }

    public static void main(String[] args) {
        //使用内部类的练习
        LambdaTest A = new LambdaTest();
        innerClass B = A.new innerClass();

        //使用匿名内部类的练习
        Thread runner = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });

        //使用lambda表达式跳过实现类创建对象，前提是该接口只有一个方法
        // TODO 除此之外还有啥用
        Runnable runner2 = () -> {System.out.println("lambda");};
        runner2.run();
    }
}
