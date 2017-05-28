package proxy;

/**
 * Created by 冰封承諾Andy on 2017/5/25.
 * 被代理者，定义具体的方法
 */
public class StandardLoli implements Loli {
    @Override
    public void hug(String name) {
        System.out.println("(づ｡◕‿‿◕｡)づ");
    }

    @Override
    public String eat() {
        System.out.println("开吃....");
        return "吃饱了";
    }
}
