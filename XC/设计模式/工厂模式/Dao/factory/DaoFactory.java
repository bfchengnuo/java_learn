package com.bfchengnuo.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by 冰封承諾Andy on 4/28/2017.
 * Dao 层的工厂模式
 * 1.采用单例模式保证本工厂只有一个（非必须）
 * 2.各层之间能达到完全解耦的目的，但是代码的复杂度会增加（双刃剑）
 *      根据传入的接口创建配置文件中的指定的实现对象，只需要修改配置文件而无需修改代码
 *
 * 如果项目确定不会更换 Dao 层，那么不使用工厂模式比较好
 */
class DaoFactory {
    private Properties daoConfig = new Properties();
    private static DaoFactory daoFactory = new DaoFactory();

    private DaoFactory() {
        // 因为采用单例模式，所以对象只有一个，也就是构造函数只会执行一次
        // 用来加载配置文件，当然也可以放在静态代码块
        InputStream in = DaoFactory.class.getClassLoader().getResourceAsStream("dao.properties");
        try {
            daoConfig.load(in);
        } catch (IOException e) {
            // 读取文件异常，下面的也就没必要执行了，直接抛 运行时异常
            throw new RuntimeException(e);
        }
    }

    static DaoFactory getDaoFactory() {
        return daoFactory;
    }

    <T> T createDao(Class<T> clazz) {
        String name = clazz.getSimpleName();
        String className = daoConfig.getProperty(name); // 获取完整类名

        try {
            // 根据接口名，创建相应的已经实现的对象
            T dao = (T) Class.forName(className).newInstance();
            return dao;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
