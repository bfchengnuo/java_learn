//final修饰的方法 是最终方法 可以被继承 不能被覆盖（重写）
public class TestFinal2{
	public static void main(String[] args){
		C cc = new C();
		cc.gogogo();
	}
}
class A{
	public final void gogogo(){
		System.out.println("伟大的最终方法");
	}
}
class C extends A{

}