package com.bfchengnuo.file;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 冰封承諾Andy on 5/9/2017.
 * 文件处理的相关操作
 */
public class Main {
    public static void main(String[] args) {
        isExtension();
        // System.out.println(savePath("abc", "ccabd"));
    }

    private static String savePath(String path,String name) {
        // 根据文件名进行哈希化
        int hashcode = name.hashCode();
        // 第一层目录根据哈希值的后四位为目录
        int dir1 = hashcode & 0xf;
        // 第二层目录根据右移后的哈希的后四位
        int dir2 = (hashcode >> 4) & 0xf;

        String savepath = path + File.separator + dir1 + File.separator + dir2;
        File file = new File(savepath);
        if (!file.exists()){
            file.mkdirs(); // 返回是否创建成功
        }
        return savepath;
    }

    private static boolean isExtension() {
        List list = Arrays.asList("jpg","png","jpeg");

        if (list.contains("jpg")) {
            System.out.println("success!");
            return true;
        }
        return false;
    }
}
