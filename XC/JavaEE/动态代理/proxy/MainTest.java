package proxy;

/**
 * Created by 冰封承諾Andy on 2017/5/25.
 * 代理测试类
 */
public class MainTest {
    public static void main(String[] args) {
        StandardLoliProxy proxy = new StandardLoliProxy();
        Loli loli = proxy.createProxy();

        loli.hug("bfchengnuo");
        System.out.println("------------------------");
        String result = loli.eat();
        System.out.println("----------"+ result +"--------------");
        // loli.hashCode();
    }
}
