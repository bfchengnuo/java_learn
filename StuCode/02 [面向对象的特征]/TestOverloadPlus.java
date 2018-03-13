public class TestOverloadPlus{
	public static void main(String[] args){
		/*
			1st.请问当前代码当中有没有出现方法重载? 有
			2nd.[C类从A类继承来的无参test] 和 [C类定义的int参数的test] 满足方法重载
		*/
	}
}
class A{
	public void test(){
		System.out.println("A类的test方法");
	}
}
class C extends A{
	public void test(int x){
		System.out.println("C类的test方法");
	}
}