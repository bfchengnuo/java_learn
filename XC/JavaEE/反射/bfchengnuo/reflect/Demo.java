package bfchengnuo.reflect;

import java.lang.reflect.Constructor;

import org.junit.Test;

public class Demo {

	//反射的演示
	public static void main(String[] args) throws Exception {
		
//		将字节码文件加载进内存
		Class clazz = Class.forName("bfchengnuo.reflect.Text");
		
		//获取一个空构造函数
		Constructor c = clazz.getConstructor(null);
		//利用空的构造函数创建一个对象
		Text tex = (Text) c.newInstance(null);
		
		System.out.println(tex.num);
	}

	@Test
	public void text() throws Exception{
		Class clazz = Class.forName("bfchengnuo.reflect.Text");
		Constructor c = clazz.getConstructor(String.class);
		Text tex = (Text) c.newInstance("aaa");
		System.out.println(tex.num);
	}
	
	@Test
	//获取私有的构造函数
	public void text1() throws Exception{
		Class clazz = Class.forName("bfchengnuo.reflect.Text");
		Constructor c = clazz.getDeclaredConstructor(int.class);
		c.setAccessible(true); //暴力访问
		Text tex = (Text) c.newInstance(2);
		System.out.println(tex.num);
	}
	
	//反射创建对象的另一种方法
	@Test
	public void text2() throws Exception{
		Class clazz = Class.forName("bfchengnuo.reflect.Text");
		//这个方法只适用于无参的构造函数
		Text tex = (Text) clazz.newInstance();
		System.out.println(tex.num);
	}
}
