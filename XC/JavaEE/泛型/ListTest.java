import java.util.*;

/**
 * Created by 冰封承諾Andy on 2017/3/23 0023.
 * 泛型 自定义泛型 迭代器
 */
public class ListTest {
    public static void main(String[] args) {
        // listTest();
        mapTest();
    }

    private static void mapTest() {
        // map的K,V必须是对象，不能是基本数据类型
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"aa");
        map.put(2,"bb");
        map.put(3,"cc");

        // keySet entrySet
        Set<Map.Entry<Integer,String>> set = map.entrySet();
        Iterator<Map.Entry<Integer, String>> iterator = set.iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, String> next = iterator.next();
            System.out.println(next.getKey() + "value=" + next.getValue());
        }
    }

    private static void listTest() {
        List<String> list = new ArrayList<>();
        list.add("s1");
        list.add("s2");
        list.add("s3");

        // 使用迭代器，当然使用foreach最好
        Iterator<String> it = list.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }

    // 自定义泛型
    class genericTest<G>{

        // 先声明然后再使用，写在返回值前面，可以直接在类上声明
        private <T> void a(T t){
            System.out.println("自定义泛型");
        }

        // 声明多个，返回值也可以是自定泛型，传来的t是什么类型，返回的就是什么类型，这样避免了返回obj强转
        private <T,K> T b(T t,K k){
            System.out.println("自定义泛型");
            return null;
        }

        // 如果是静态方法，类的自定泛型无效
        private G c(G g){
            System.out.println("自定义泛型");
            return null;
        }

        // 交换任意数组的顺序
        private <T> void reverse(T[] array){
            int start = 0;
            int end = array.length - 1;

            while (start<=end){
                T temp = array[start];
                array[start] = array[end];
                array[end] = temp;

                start++;
                end--;
            }
        }
    }
}
