package com.bfchengnuo.prop;

import java.io.*;
import java.util.Properties;

/**
 * 操作 Prop 文件的简单例子
 */
public class Simple {
    public static void main(String[] args) throws IOException {
//        setAndGet();
        loadAndSave();
    }

    private static void loadAndSave() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("prop.properties");

        prop.load(fis);

        prop.setProperty("abc", "123");

        for (String s : prop.stringPropertyNames()) {
            System.out.println(s + "::" + prop.getProperty(s));
        }

        // 此流会覆盖源文件，所以要在 load 以后执行
        FileOutputStream fos = new FileOutputStream("prop.properties");
        prop.store(fos,"这是注释");

//        prop.list(System.out);

        fis.close();
        fos.close();
    }

    private static void setAndGet() {
        Properties prop = new Properties();

        prop.setProperty("loli", "12");
        prop.setProperty("sky", "10");
        prop.setProperty("bf", "11");


        // 循环遍历 Set 集合
        for (String s : prop.stringPropertyNames()) {
            System.out.println(s + "::" + prop.getProperty(s));
        }
    }


    // 小栗子
    private static void exp1() throws IOException {
        Properties prop = new Properties();
        File file = new File("prop.properties");
        if (!file.exists()) {
            if (!file.createNewFile()) {
                System.out.println("创建文件失败！！");
            }
        }

        FileInputStream fis = new FileInputStream(file);

        prop.load(fis);  // 字节流字符流都可以

        // 可以读取数据了

        FileOutputStream fos = new FileOutputStream(file);

        prop.store(fos,"");

        fis.close();
        fos.close();
    }
}
