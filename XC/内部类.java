class NeiBu
{
	public static void main(String[] args)
	{
		Wai w = new Wai();
		w.Fw();
		//直接访问内部类的成员
		/* 
		Wai.Nei ls = new Wai().new Nei();
		ls.show();
		 */
		//如果内部类是静态的，相当于一个外部类
		/* 
		Wai.Nei lss = new Wai.Nei();
		lss.show();
		 */
		//如果成员也是静态的
		// Wai.Nei.show();
		//由于ceshi原因 静态已经去掉
	}
}

class Wai
{
	int ceshi = 1;
	static int num = 2;
	 class Nei
	{
		int ceshi = 2;
		//内部定义为静态  此类必须为静态
		void show()
		{
			int ceshi = 3;
			//可以访问外面的变量
			System.out.println("我是内部类 num = " +num);
			//开发上不会采用以下
			System.out.println("内部的ceshi = "+ ceshi);
			System.out.println("内部的this.ceshi = "+ this.ceshi);
			System.out.println("内部的Wai.this.ceshi = "+ Wai.this.ceshi);
		}
	}
	
	void Fw()
	{
		Nei n = new Nei();
		n.show();
	}
}


PS：  不常用

class Wai
{
	int num = 2;  //必须加final
	/* 
	如果不定义为 final 如果下面的调用类返回一个类（地址）赋给新的类，那么执行完毕num随即消失，再次使用的时候num就无法访问，加上final后就成为最终值（常量）
	 */
	void show()
	{
		class Nei
		{
			void shows()
			{
				System.out.println("num = "+num);
			}
		}
		Nei ls = new Nei();
		ls.shows();
	}
}

++匿名内部类

new 抽象类 （）
{
	代码
}.show();