package iO_properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class PropertiesText {

	public static void main(String[] args) throws IOException {
		// TODO 自动生成的方法存根

		/*
		 * Map
		 * 	|--Hashtable
		 * 		|--Properties:
		 * 
		 * Properties集合：
		 * 特点：
		 * 1，该集合中的键和值都是字符串类型。
		 * 2，集合中的数据可以保存到流中，或者从流获取。
		 * 
		 * 通常该集合用于操作以键值对形式存在的配置文件。 
		 * 
		 * 
		 */
		
		// propdd();
//		将数据写入到文件
		// file1();
//		从文件加载数据  配置文件
//		file2();
//		读取文件 并且修改文件
		file3();
	}

	private static void file3() throws IOException {
		//读取文件
		File file = new File("info.txt");
		//如果文件不存在  那么就新建一个
		if(!file.exists()){
			file.createNewFile();
		}
//		开启一个字符流
		FileReader fr = new FileReader(file);
		// 创建集合
		Properties prop = new Properties();
		
//		将流中的信息存储到集合中
		prop.load(fr);
		
//		修改数据
		prop.setProperty("loli_a", "ssss");
		
		
//		开启一个输出字符流，此流会覆盖原文件，所以应该在load之后创建
		FileWriter fw = new FileWriter(file);
//		将集合数据存储到文件
		prop.store(fw, "");
		
//		关闭流
		fw.close();
		fr.close();
	}

	private static void file2() throws IOException {
		Properties prop = new Properties();
//		要保证文件是键值对    字节流--不用刷新也可以存入？？哈
		FileInputStream fis = new FileInputStream("info.txt");
		
//		使用load方法
		prop.load(fis);
		
		prop.list(System.out);
	}

	private static void file1() throws IOException {
		Properties prop = new Properties();
		
		prop.setProperty("loli_a", "skye1");
		prop.setProperty("loli_b", "skye2");
		prop.setProperty("loli_c", "skye3");
		prop.setProperty("loli_d", "skye4");
		prop.setProperty("loli_e", "skye5");
		
//		存到文件中，关联输出流,字节流
		FileOutputStream fos = new FileOutputStream("info.txt");
		
//		将集合中的数据存储到文件，使用store方法
		prop.store(fos, "text");
		
//		一定要关闭流
		fos.close();
	}

	private static void propdd() {
//		创建 Prop集合
		Properties prop = new Properties();
		
//		存储数据 键值对 都是字符串类型
		prop.setProperty("lolia", "01");
		prop.setProperty("lolib", "02");
		prop.setProperty("lolic", "03");
		prop.setProperty("lolid", "04");
		
//		修改元素的值
		prop.setProperty("lolia", "sss");
		
		//与流相结合输出，获取系统信息属性
		// prop = System.getProperties();
		
		//将属性列表输出到指定的输出流。此方法对调试很有用。
		prop.list(System.out);
		
		
		
		
		/* 第一种取出方法
		
//		取出所有元素,高级for
		Set<String> names = prop.stringPropertyNames();
		
		for(String name : names){
//			根据键取值
			String val = prop.getProperty(name);
			System.out.println(name+":"+val);
		}
		*/
	}

}
