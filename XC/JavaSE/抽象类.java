class chouxiang
{
	public static void main(String[] args)
	{
		System.out.println(lss.num);
		
		show(new deo());
		//使用匿名内部类，不用定义deo类，为了易读性，函数/方法不要超过3个
		show(new lss()
		{
			int num = 3;
			public void shows()
			{
				System.out.println("show run");
			}
	
			public void ceshi()
			{
				
				System.out.println("ceshi---num = "+num);
			}
		}
		);
	}
	
	public static void show(lss ls) 
	// public static void show(deo ls)    两种都可以耶
	{
		ls.shows();
		ls.ceshi();
	}
}

interface lss
{
	//变量可以声明  无法被覆盖 也不需要被覆盖
	public static final int num = 4;
	public abstract void shows();
	public abstract void ceshi();
}

class deo implements lss
{
	int num = 3;
	public void shows()
	{
		System.out.println("show run");
	}
	
	public void ceshi()
	{
		
		System.out.println("ceshi---num = "+num);
	}
}


PS：匿名内部类

class demo
{
	// Object s = new ...
	// 这属于一个多态，编译看左边，子类特有的函数无法调用
	new Object()
	{
		//相当于一个类里了
		public void show()
		{
			System.out.println("show run");
		}
	}.show();
	//运行结果就是 打印~
	// s.show  无法调用  已经发生向上转型  0.0未测试
}