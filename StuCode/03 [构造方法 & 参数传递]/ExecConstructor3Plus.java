public class ExecConstructor3Plus{
	public static void main(String[] args){
		D dd = new D();
	}
}
class A{
	public A(){
		System.out.println("A类无参构造方法");
	}
	public A(int x){
		super();
		System.out.println("A类int参数构造方法");
	}
}
class C extends A{
	public C(int x){
		super(66);
		System.out.println("C类int参数构造方法");
	}
	public C(long x){
		super();
		System.out.println("C类long参数构造方法");
	}
}
class D extends C{
	public D(){
		super(77);
		System.out.println("D类无参的构造方法");
	}
}