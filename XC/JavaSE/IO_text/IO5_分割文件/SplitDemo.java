package iO_split;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class SplitDemo {

	public static void main(String[] args) throws IOException {

		
		File ff = new File("c:\\0.jpg");
		splitff_1(ff);
	}

	private static void splitff_1(File ff) throws IOException {
		// TODO 自动生成的方法存根
		
		//用读取流关联要分割的文件
				FileInputStream fis = new FileInputStream(ff);
				
				//创建缓冲区
				byte[] tem = new byte[1024];
				
				//创建目的流
				FileOutputStream fos = null;
				
				int len = 0;
				int count = 1;
				
				//目的文件夹
				File fle = new File("c:\\abc");
//				健壮性判断  如果不存在就创建一个文件夹
				if(!fle.exists()){
					fle.mkdir();
				}
				
//				将文件分割为缓冲区大小的文件
				while ((len = fis.read(tem)) != -1) {
					fos = new FileOutputStream(new File(fle, (count++)+".part"));
					//将缓冲区的数据写入，字节流不需要刷新,最终长度不确定所以指定
					fos.write(tem,0,len);
					//关闭流
					fos.close();
				}
				
				/*
				 * 创建配置文件，记录分割信息，便于以后的文件合并
				 * */
				
				// Properties 类/集合    	表示了一个持久的属性集。Properties 可保存在流中或从流中加载。
				Properties prop = new Properties();
				
				prop.setProperty("partcount", count+"");
				prop.setProperty("filename", ff.getName());
				
				//开一个输出流 写配置文件
				fos = new FileOutputStream(new File(fle,count+".properties"));
				//将配置信息保存，标记省略
				prop.store(fos, "");
				
				fos.close();
				fis.close();
	}

	private static void splitff(File ff) throws IOException {
		// TODO 自动生成的方法存根
		
		
		//用读取流关联要分割的文件
		FileInputStream fis = new FileInputStream(ff);
		
		//创建缓冲区
		byte[] tem = new byte[1024*1024];//这里最好写定值
		
		//创建目的流
		FileOutputStream fos = null;
		
		int len = 0;
		int count = 1;
		
		//目的文件夹
		File fle = new File("c:\\abc");
//		健壮性判断  如果不存在就创建一个文件夹
		if(!fle.exists()){
			fle.mkdir();
		}
		
//		将文件分割为缓冲区大小的文件
		while ((len = fis.read(tem)) != -1) {
			fos = new FileOutputStream(new File(fle, (count++)+".part"));
			//将缓冲区的数据写入，字节流不需要刷新,最终长度不确定所以指定
			fos.write(tem,0,len);
			//关闭流
			fos.close();
		}
		
		fis.close();
	}

}
