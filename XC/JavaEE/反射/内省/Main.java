package javabean;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by 冰封承諾Andy on 2017/3/21 0021.
 * java bean 相关
 *
 * 还有很多第三方的工具，在Bean复制性能上，排名（2010）：
 * 1. BeanCopier.create
 * 2. org.springframework.beans.BeanUtils.copyProperties
 * 3. PropertyUtils.copyProperties
 * 4. BeanUtil.copyProperties
 *
 * 避免用Apache BeanUtils 进行属性的copy。Apache BeanUtils性能较差，可以使用其他方案比如Spring BeanUtils。
 */
public class Main {
    public static void main(String[] args) throws IntrospectionException {
        // 获取javabean的所有属性
        //BeanInfo beanInfo = Introspector.getBeanInfo(Stu.class);
        // 除去从obj继承的属性
        BeanInfo beanInfo = Introspector.getBeanInfo(Stu.class,Object.class);
        PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();  // 得到属性描述符
        for (PropertyDescriptor pd : pds) {
            // 获得属性名
            System.out.println(pd.getName());
            // 得到 pb 对象后可以调用 getWriteMethod 等方法了，具体看下面的方法吧
        }
    }

    // 操作 bean 的指定属性
    public void test() throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        // 通过属性描述符来确定那个属性，也就是操作那个属性
        PropertyDescriptor pd = new PropertyDescriptor("name",Stu.class);
        // 相当于是拿到set方法
        Method writeMethod = pd.getWriteMethod();
        // 执行方法，填充数据
        writeMethod.invoke(new Stu(),"loli");

        // 拿到get方法
        Method readMethod = pd.getReadMethod();
        readMethod.invoke(new Stu(),null);

        // 获取是什么类型
        Class<?> type = pd.getPropertyType();
        System.out.println(type);
    }
}
