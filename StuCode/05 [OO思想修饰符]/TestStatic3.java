public class TestStatic3{
	public static void main(String[] args){
		System.out.println(A.i);
		A a1 = new A();
		A a2 = new A();
		A a3 = new A();
	}
}
class A{
	static int i;
	static{
		i = 3;
	}
	static{//静态初始化块 用于初始化静态成员
		i = 7;
		System.out.println("你看我美吗");
	}
}
