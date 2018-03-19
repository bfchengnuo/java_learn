public class TestInterfaceJDK8{
	int i = 8;
	public static void main(String[] args){
		A.test1();
	}
}
interface A{
	public static void test1(){
		System.out.println("接口当中可以定义静态方法了");
	}
	public default void test2(){
		System.out.println("接口当中可以出现default修饰的默认方法实现");
	}
}