package annatotion;

import java.lang.reflect.Method;

/**
 * Created by 冰封承諾Andy on 2017/5/24.
 * 注解的测试
 */
public class Main {
    private static String name;

    static {
        try {
            // 通过反射，获取注解的信息，首先获取到方法，这个是获取公共方法的....
            Method method = Main.class.getMethod("test");
            // 获取到注解信息
            MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
            name = annotation.name();
            System.out.println(name);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws NoSuchMethodException {
        // test();
    }

    @MyAnnotation(name = "loli", age = 12, value = {"test"})
    public static void test() throws NoSuchMethodException {
        // TODO: 2017/5/24  
    }
}
