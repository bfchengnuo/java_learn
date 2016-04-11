package bfchengnuo.reflect;

import java.lang.reflect.Method;

import org.junit.Test;

public class DemoFunction {

	@Test
	public void demo() throws Exception{
		Text tex = new Text();
		Class clazz = Class.forName("bfchengnuo.reflect.Text");
		
		//从字节码文件获取函数，第一个参数为函数名，第二个参数为函数需要传入的参数
		Method me = clazz.getMethod("show", null);
		//让函数跑起来，第一个为对象，第二个函数跑起来需要的参数
		me.invoke(tex, null);
		
	}
}
