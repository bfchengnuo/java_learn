package com.bfchengnuo.File;

import java.io.*;

/**
 * 字节流的操作
 */
public class IOStream {
    public static void main(String[] args) {
        copy();
    }


    private static void copy() {
        BufferedInputStream bufis = null;
        BufferedOutputStream bufos = null;
        try {
            bufis = new BufferedInputStream(new FileInputStream("test.txt"));
            bufos = new BufferedOutputStream(new FileOutputStream("test.txt"));

            int len;
            // 先把文件的部分内容读到缓冲区（字节数组），再从缓冲区一个一个的读
            while ((len = bufis.read()) != -1) {
                bufos.write(len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (bufis != null) {
                try {
                    bufis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufos != null) {
                try {
                    bufos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 手动定义缓冲区
     *
     * @throws IOException 读取异常
     */
    public static void copy_1() throws IOException {

        FileInputStream fis = new FileInputStream("c:\\0.mp3");
        FileOutputStream fos = new FileOutputStream("c:\\1.mp3");

        byte[] buf = new byte[1024];

        int len = 0;

        while((len=fis.read(buf))!=-1){
            fos.write(buf,0,len);
        }

        fos.close();
        fis.close();
    }
}
