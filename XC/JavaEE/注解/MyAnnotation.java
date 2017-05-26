package annatotion;

import java.lang.annotation.*;

/**
 * Created by 冰封承諾Andy on 2017/5/24.
 * 自定义注解
 * 作用在注解上的注解叫元注解
 * java 有三种状态：java 原文件 ----class 编译后文件 -----运行时
 *
 * Retention 元注解作用是指定保留域； 默认是 class 级别
 *
 * Target 元注解作用是：指定作用在哪里，比如，方法、类、构造等
 *      默认 可作用在类的所有成员上
 *
 * Inherited 元注解：使其具有继承性
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
public @interface MyAnnotation {
    // 可以定义八种基本数据类型、字符串、其他注解、类、枚举；当然也可以是数组
    String name();
    int age();

    // 可以配置缺省值
    Class clazz() default String.class;

    // value 是比较特殊的，只有一个属性 value 的话，赋值的时候可以省略属性名
    String[] value();
}
