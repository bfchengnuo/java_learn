package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by 冰封承諾Andy on 2017/3/21 0021.
 * 反射测试文件
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        //获得类的字节码文件，三种方式
        Class<Student> clazz = (Class<Student>) Class.forName("reflect.Student");
        //Class clazz = new Student().getClass();
        //Class clazz = Student.class;

        // 构造函数的测试
        //gzTest(clazz);

        //获取方法
        //methodTest(clazz);

        // 获取字段
        fieldTest(clazz);
    }

    private static void fieldTest(Class<Student> clazz) throws NoSuchFieldException, IllegalAccessException {
        Student stu = new Student("loli");
        // 可以获取所有的字段(成员变量)，包括私有、受保护的，但是父类的属性不会被返回
        // 而 getField 方法可以获取到父类的公共的属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        if (name.getType().equals(String.class)){
            String str = (String) name.get(stu);
            System.out.println(str);
        }
    }

    private static void methodTest(Class<Student> clazz) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Student stu = new Student("佳芷");
        Method method = clazz.getMethod("printName", null);
        // 执行
        method.invoke(stu, null);

        // 调用main方法，静态方法不需要对象
        Method method1 = clazz.getMethod("main", String[].class);
        // 在jdk1.5以前，没有可变参数，为适应多个参数的方法，所以参数类型为数组，执行的时候如果是数组就拆成多个参数
        //method1.invoke(null, new String[]{"1", "2"}) --->>相当于main(string s1,string s2)
        // 参数为数组的时候，为了防止拆分，所以把数组转换成obj，或者外面再套一层数组
        method1.invoke(null, (Object) new String[]{"1", "2"});
    }

    private static void gzTest(Class<Student> clazz) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        //获得构造函数，用来创建对象
        //clazz.getDeclaredConstructor();  获得私有的构造函数，其实这个方法是获取所有的构造，包括私有和受保护的
        //constructor.setAccessible(true);   暴力反射，强制设置为可访问权限，然后就可以new对象了

        Constructor<Student> constructor = clazz.getConstructor();
        Student student = constructor.newInstance();
        //无参的构造函数可以直接这样写
        //Student student = (Student) clazz.newInstance();
        System.out.println(student.test);

        //有参的构造函数
        Constructor<?> constructor2 = clazz.getConstructor(String.class);
        Student student2 = (Student) constructor2.newInstance("佳芷");
        System.out.println(student2.getName());
    }
}
