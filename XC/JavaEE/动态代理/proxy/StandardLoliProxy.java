package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by 冰封承諾Andy on 2017/5/25.
 * 用于生成代理，也就是具体的代理人
 *
 * 1.首先要 new 出一个被代理者的对象
 * 2.使用 Proxy.newProxyInstance 创建出一个代理，
 */
public class StandardLoliProxy {
    private StandardLoli mLoli = new StandardLoli();

    public Loli createProxy() {
        // 固定写法
        // 1.第一个参数是类加载器，用当前的类获取就可以
        // 2.第二个为被代理者的接口，是接口
        // 3.第三个为核心，返回的代理调用时就是调用这个方法
        //      在这个方法里判断是调用的那个方法，然后执行相应的处理
        return (Loli) Proxy.newProxyInstance(StandardLoliProxy.class.getClassLoader(), mLoli.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equalsIgnoreCase("hug")) {
                    System.out.println("确认身份...");
                    if (args[0].equals("bfchengnuo")) {
                        return method.invoke(mLoli, args);
                    }
                } else if (method.getName().equalsIgnoreCase("eat")) {
                    System.out.println("代理人...");
                    return method.invoke(mLoli, args);
                }
                System.out.println("其他方法不允许执行！");
                return null;
            }
        });
    }
}
