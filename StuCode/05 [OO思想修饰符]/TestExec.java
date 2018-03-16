public class TestExec{
	public static void main(String[] args){
		C no1 = new C();
		System.out.println("==============");
		C no2 = new C();
		System.out.println("==============");
		C no3 = new C();
	}
}
class A{
	public A(){
		System.out.println("A类的构造方法");
	}
	{
		System.out.println("A类的非静态初始化块");
	}
	static{
		System.out.println("A类的静态初始化块");
	}
}
class C extends A{
	public C(){
		System.out.println("C类的构造方法");
	}
	{
		System.out.println("C类的非静态初始化块");
	}
	static{
		System.out.println("C类的静态初始化块");
	}
}