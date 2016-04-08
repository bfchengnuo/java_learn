package iO1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Copytext {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		// 同时读写文件操作
		// 写在try的外面
		FileReader fr = null;
		FileWriter fw = null;
		try {
			fr = new FileReader("demo.txt");
			fw = new FileWriter("demo2.txt");
			// 设置缓存空间，以1024的倍数为佳
			char[] ch = new char[1024];
			// 用来记录读取字符的个数
			int len;
			while ((len = fr.read(ch)) != -1) {
				/*
				write(char[] cbuf, int off, int len) 
				写入字符数组的某一部分。
				所以是不会覆盖原来写的内容的
				*/
				fw.write(ch, 0, len);
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException();
		} finally {
			if (fr != null)
				try {
					fr.close();
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			if (fw != null)
				try {
					fw.close();
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}

		}
	}

}
