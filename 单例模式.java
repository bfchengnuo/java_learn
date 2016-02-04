/* 
单例设计模式
		保证一个类在内存中对象的唯一性，只能有一个对象
		私有化构造函数、、通过new在本类中创建一个本类对象、、定义一个公有方法返回创建的对象
*/
class danli
{
	public static void main(String[] args)
	{
		demo ls =  demo.getInstance();  // （）不能忘啊！！！
		demos lss = demos.getInstance();
		//临时起意
		// ceshi x = new ceshi();   原来是这么调用的
		// ceshi x = new ceshi;		错误
		// new ceshi.show();		错误
		// new ceshi().show();			正确的使用，又是因为括号啊！！！
	}
}
//饿汉式  开发
class demo
{
	private static demo s = new demo();  //静态，类加载就存在
	private demo(){};
	public static demo getInstance()
	{
		return s;
	}
}
//懒汉式  面试
class demos
{
	private static demos s = null;
	private demos(){};
	public static demos getInstance()
	{
		s = new demos();
		return s;
	}
}

class ceshi
{
	void show()
	{
		System.out.println("yes!");
	}
}
		 