package com.bfchengnuo.File;

import java.io.*;

// 字符流的测试类
public class ReadAndWriter {

    public static void main(String[] args) throws IOException {
        // 第二个参数传入 true 可实现对文件的追加
        FileWriter fw = new FileWriter("test.txt");
        FileReader fr = new FileReader("test.txt");

        String data = " 我是数据,lllllllllllllllllllllllllllllllllllllllxxxxxxxxxxxxxxxxxxxxxx";

        fw.write(data);
        fw.close();

        int ch = 0;
        while ((ch = fr.read()) != -1){
            // 自动查码表
            System.out.print((char)ch);
        }

        fr.close();


//        data.getBytes();
//        byte[] a;
    }

    public void WriterFile() {
        String data = "xxxxxxxxxxxxx我是数据";
        FileWriter fw = null;
        try {
            // true 代表以追加的形式写入，也可以使用一个参数的构造方法（不使用追加）
            // 如果文件不存在此方法会自动创建文件
            fw = new FileWriter("test.txt",true);
            fw.write(data);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fw != null)
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    public void ReadFile() {
        FileReader fr = null;
        try {
            fr = new FileReader("test.txt");

            // 单个读取
            int ch = 0;
            while ((ch = fr.read()) != -1){
                // 自动查码表
                System.out.print((char)ch);
            }

            // 使用缓冲区
            char[] buf = new char[1024];
            int len = 0;
            while ((len = fr.read(buf)) != -1){
                System.out.print(new String(buf,0,len));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void WriterFileBufr() {
        FileWriter fw = null;
        try {
            fw = new FileWriter("test.txt");
            BufferedWriter bufw = new BufferedWriter(fw);

            for (int i = 0; i < 4; i++) {
                bufw.write("test + " + i);
                // 根据系统插入相应的换行
                bufw.newLine();
                bufw.flush();  // 使用缓冲区，记得刷新
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (fw != null)
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void ReadFileBufr() {
        FileReader fr = null;
        try {
            fr = new FileReader("tesst.txt");
            BufferedReader bufr = new BufferedReader(fr);
            String len;
            while ((len = bufr.readLine()) != null) {
                // 并不会读取换行符，所以需要手动换行
                System.out.println(len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void copy() {
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
}
