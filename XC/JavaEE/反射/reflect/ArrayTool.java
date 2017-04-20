package reflect;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by 冰封承諾Andy on 4/20/2017.
 * 数组转换为 List
 * 无论是对象类型还是基本类型
 */
public class ArrayTool {
    private Collection collection;

    private Collection toList(Object items) {
        // 判断是不是数组，包括基本数据类型和引用数据类型
        if (items.getClass().isArray()) {
            this.collection = new ArrayList();

            // Array 是反射包里的
            int len = Array.getLength(items);
            for (int i = 0; i < len; i++) {
                Object val = Array.get(items, i);
                this.collection.add(val);
            }
            return collection;
        }
        return null;
    }
}
