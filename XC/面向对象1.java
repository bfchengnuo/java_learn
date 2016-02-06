class Csong
//类中的成员变量都会默认初始化，在堆中存储
	{
		int a = 1;     //这里赋值，在主函数调用依然可以改变
		String b;		//字符串初始化为null
		
		void run()
		{
			// a = 10;   下面的输出语句优先在本代码块查找，如果次行代码有效，a的值为10
			System.out.println("a = "+a+"b = "+b);
		}
	}
class demo
{
	
	public static void main(String[] args)
	{
		//定义，调用方法
		Csong ls = new Csong () ;
		ls.a = 5;
		ls.run();
	}
	
}
