class jicheng
{
	public static void main(String[] args)
	{
		Zi s = new Zi();
		s.show();
	}
}

class Fu
{
	int number = 3;
	Fu()
	{
		省略了 super() 任何类的共性，父类 object，虚拟机启动就已经加载
		show();
		return ;
	}
	// 被覆盖，上面的调用会优先从子类里查找，避免被覆盖使用final修饰符
	void show()
	{
		System.out.println("fu number="+number);
	}
}

class Zi extends Fu
{
	int number = 5;
	Zi()
	{
		super();
		// 分界线，从这里才开始显示初始化，初始化父类完成后
		System.out.println("zi-- number="+number);
	}
	void show()
	{
		System.out.println("zi number="+number);
	}
}