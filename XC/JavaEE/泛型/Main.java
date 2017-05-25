package generic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by 冰封承諾Andy on 2017/5/24.
 *
 */
public class Main {
    public static void main(String[] args) {
        new RGTest();
        test(new ArrayList<String>());
    }


    // 使用通配符
    // <T>  <E>  是定义的时候设置， <?> 是使用的时候
    private static void test(Collection<?> c) {
        // 如果使用了通配符，那么泛型相关的方法就不能再用
        // string 集合不能存数字吧
        // c.add(123);

        System.out.println(c.size());
    }

    // 限制泛型
    private class RG<T extends Serializable & Cloneable> {
    }

    // 通配符的限制，一般通配符使用在当作某个方法的参数的时候
    private static void test2(ReflectGeneric<? super Integer> r) {
    }
}

// 只为测试
class RGTest extends ReflectGeneric<String> {
}
