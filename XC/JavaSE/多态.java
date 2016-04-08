class DuoTai
{
	public static void main(String[] args)
	{
		//编译的时候看右边，运行的时候看左边
		Fu F = new Zi();
		F.show();
		//成员变量不会覆盖，只是覆盖函数
		System.out.println(F.num);
		//
		//
		F.Sp();
		// F.Spi();  编译失败 编译看左边，Fu中没有Spi
		Zi z = (Zi)F;
		z.Spi();
		//静态类  统一看左边  因为没有创建对象，不捆绑
		// 可以直接用类名调用
		Fu.Cs();
		F.Cs();
		
	}
}

class Fu
{
	int num = 2;
	void show()
	{
		System.out.println("Fu num = "+num);
	}
	//
	void Sp()
	{
		System.out.println("Fu de Sp");
	}
	//
	static void Cs()
	{
		System.out.println("St is Fu");
	}
}

class Zi extends Fu
{
	int num = 5;
	void show()
	{
		System.out.println("Zi num = "+num);
	}
	//
	void Spi()
	{
		System.out.println("Zi de Sp");
	}
	//
	static void Cs()
	{
		System.out.println("st is Zi");
	}
}