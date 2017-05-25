package generic;

import java.lang.reflect.ParameterizedType;

/**
 * Created by 冰封承諾Andy on 2017/5/24.
 * 反射类型的泛型使用
 * 功能为：获取泛型的 class
 */
public class ReflectGeneric<T> {
    private Class clazz;  //获取泛型的 class

    ReflectGeneric() {
        // 谁调用这个方法，this 就代表谁；所以下面的是：
        // 获取子类的对象，再获取泛型化了的父类（这就是本类）
        // ReflectGeneric<String> 称为参数化的类型  ParameterizedType
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        // 获取泛型里的实际对象
        clazz = (Class) pt.getActualTypeArguments()[0];
        System.out.println(clazz);
    }
}
