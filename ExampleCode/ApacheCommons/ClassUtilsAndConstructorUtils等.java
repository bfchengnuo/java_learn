// ClassUtils
public class TestMain {
    public static void main(String[] args) {  
        // 获取Test类所有实现的接口  
        ClassUtils.getAllInterfaces(Test.class);  
 
        // 获取Test类所有父类  
        ClassUtils.getAllSuperclasses(Test.class);  
 
        // 获取Test类所在的包名  
        ClassUtils.getPackageName(Test.class);  
 
        // 获取Test类简单类名  
        ClassUtils.getShortClassName(Test.class);  
 
        // 判断是否可以转型  
        ClassUtils.isAssignable(Test.class, Object.class);  
 
        // 判断是否有内部类  
        ClassUtils.isInnerClass(Test.class);
    }
}

// ConstructorUtils
public class TestMain {
    public static void main(String[] args) {
        // 获取参数为String的构造函数  
        ConstructorUtils.getAccessibleConstructor(Test.class, String.class);  
 
        // 执行参数为String的构造函数  
        Test test = (Test) ConstructorUtils.invokeConstructor(Test.class,  
                "Hello");  
    }
}

// MethodUtils   
public static void main(String[] args) throws NoSuchMethodException,  
            IllegalAccessException, InvocationTargetException {  
        // 调用无参方法  
        Test test = new Test();  
        MethodUtils.invokeMethod(test, "publicHello", null);  
 
        // 调用一参方法  
        MethodUtils.invokeMethod(test, "publicHello", "Hello");  
 
        // 调用多参方法  
        MethodUtils.invokeMethod(test, "publicHello", new Object[] { "100",  
                new Integer(10) });  
 
        // 调用静态方法  
        MethodUtils.invokeStaticMethod(Test.class, "staticHello", null);  
}

// FieldUtils
public class TestMain {
    public static void main(String[] args) throws IllegalAccessException {  
        Test test = new Test("1", "Ray", "hello");  
 
        // 以下两个方法完全一样,都能获取共有或私有变量,因为第三个参数都设置了不检查  
        FieldUtils.getDeclaredField(Test.class, "username", true);  
        FieldUtils.getField(Test.class, "username", true);  
 
        // 读取私有或公共变量的值  
        FieldUtils.readField(test, "username", true);  
 
        // 读取静态变量  
        FieldUtils.readStaticField(Test.class, "STATIC_FIELD");  
 
        // 写入私有或共有变量  
        FieldUtils.writeField(test, "username", "RayRay", true);  
 
        // 写入静态变量  
        FieldUtils.writeStaticField(Test.class, "STATIC_FIELD", "static_value");  
    }
}