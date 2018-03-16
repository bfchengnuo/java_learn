public class TestInit{
	public static void main(String[] args){
		A a1 = new A();
		A a2 = new A();
		A a3 = new A();
	}
}
class A{
	//类体当中只能定义成员（属性、方法）
	//不能直接写语句
	int i;
	{//初始化块 => 初始化成员变量(属性)
		i = 3;
		System.out.println("ETOAK");
	}
}

class X{
	//int a = 5;
	int a;
	{
		a = 5;
	}
}









