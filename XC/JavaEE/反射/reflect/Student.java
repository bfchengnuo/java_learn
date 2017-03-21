package reflect;

/**
 * Created by 冰封承諾Andy on 2017/3/21 0021.
 * 反射类的测试类
 */
public class Student {
    private String name;
    public String test = "测试";

    public Student() {
        System.out.println("空参的构造函数");
    }

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void printName() {
        System.out.println(name);
    }

    public static void main(String[] args) {
        System.out.println("main..run");
    }
}
