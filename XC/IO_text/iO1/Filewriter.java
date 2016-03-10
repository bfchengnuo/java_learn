package iO1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Filewriter {

	public static void main(String[] args) throws IOException {
		// TODO 自动生成的方法存根

		
		FileWriter fw = new FileWriter("demo.txt");
		//写入到数据流  还是在缓存区域
		fw.write("adawdawd");
		//刷新数据流
		fw.flush();
		
		//关闭数据流
		fw.close();
		
		FileReader fw2 = new FileReader("demo.txt");
		//推荐1024，与存储相符合
		char[] buf = new char[10];
		int len = 0;
		while ((len = fw2.read(buf)) != -1) {
			System.out.println(new String(buf,0,len));
		}
		//也要关闭数据流
		fw2.close();
	}

}
