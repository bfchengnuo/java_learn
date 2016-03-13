package iO2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class IO_system {

	
//	将输入的小写字母转化为大写
	public static void main(String[] args) throws IOException {
		// TODO 自动生成的方法存根

		//必须背过的程度掌握  			创建缓冲区      		将字节流转换为字符流    系统输入
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
//		读取文件流					必须是字节流文件
//		BufferedReader bufr = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		
		
		
//									创建缓冲区		将字符流转换成字节流输出
		BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(System.out));
//		写入到文件  同理也是用字节流  如果写入的是纯文本文件可以直接使用字符流 = new BufferedWriter(new FileWriter(file))
//										缓存区----->转换为字节流----->以字节流写入到文件
//		BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
		
		
//		读取文件都是以字符流读入，写入、保存文件都是以字节流写入到硬盘
		
		
		String ls = null;
//		一次读取一行，如果没有返回是null  只有读行是null  其他大都是-1
		while((ls = bufr.readLine()) != null){
			if("over".equals(ls)){
				break;
			}
//			转换成大写
			bufw.write(ls.toUpperCase());
//			换行输入
			bufw.newLine();
//			刷新缓冲区，因为是字符流 必须刷新才有效果，因为是系统流 所以不需要关闭流
			bufw.flush();
		}
	}

}
