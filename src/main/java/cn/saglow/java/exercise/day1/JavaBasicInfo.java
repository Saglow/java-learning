package cn.saglow.java.exercise.day1;

/**
 * Description: java的基本说明
 * Author: HW
 * Date: 2023/7/19
 */
public class JavaBasicInfo {


    static {
        // 静态代码块
        System.out.println("类加载是执行");
    }

    public static void main(String[] args) {
        new B.B_3();
        new B();
//        new A();
//        new A("1");
        System.out.println("main 函数执行");
//        new B.B_4();

        Type_3<Integer> t3 = new Type_3(18);
        System.out.println(t3.getProperty().getClass());

        Type_3<String> t4 = new Type_3("cango");
        System.out.println(t4.getProperty().getClass());

        E_interface eInterface = new E_class();
        eInterface = new E_interface() {
            @Override
            public void testE() {
                System.out.println("匿名类");
            }
        };

        NoNameClass e1 = new NoNameClass(eInterface);

        String[] a = new String[0];

        String[] b = new String[]{"1","2","3"};

    }
}


class A implements D{
    public A() {
        System.out.println("A1 构造函数执行");
    }
    public A(String name) {
        System.out.println("A(String) constract invoke");
    }

    @Override
    public void testd1() {
        System.out.println("invoke A.testd1");
    }

}

class B extends A {

    public B() {
//        super("1");
        super();
        System.out.println("B1 的构造函数");

    }

    @Override
    public void testD() {
        System.out.println("invoke b.testd");
    }

    public void testD(String name) {
        System.out.println("invoke b.testd");
    }



    @Override
    public void testd1() {
        System.out.println("invoke b.testd1");
    }

    private B_1 b1;
    private B_2 b2;
    private static class B_1 {
    }

    private class B_2 {
    }
    public static class B_3 {

    }
    public class B_4{

    }


    public class B_5{
        private B_1 b1;
    }



    // 11111
}

interface D {
    default void testD() {

    };
    void testd1();
}

interface E_interface {
    void testE();
}

class E_class implements E_interface {
    @Override
    public void testE() {
        System.out.println("invoke e_1.testE");
    }
}

class E_class2 implements E_interface {
    @Override
    public void testE() {
        System.out.println("invoke e_1.testE");
    }
}

class NoNameClass {
    public NoNameClass(E_interface e) {
        this.e = e;
    }

    private E_interface e;


    public void testE1() {
        e.testE();
    }
}
interface F extends D, E_interface {

}



class Type_1 {
    private Integer property;

    public Type_1(Integer property) {
        this.property = property;
    }
}

class Type_2 {
    private String property;

    public Type_2(String property) {
        this.property = property;
    }
}



class Type_3<T> {
    private T property;

    public Type_3(T property) {
        this.property = property;
    }

    public T getProperty() {
        return property;
    }

    public void setProperty(T property) {
        this.property = property;
    }

}

class Type_4<T,T2> {
    private T property;
    private T2 property2;

    public Type_4(T property, T2 property2) {
        this.property = property;
        this.property2 = property2;
    }
}


