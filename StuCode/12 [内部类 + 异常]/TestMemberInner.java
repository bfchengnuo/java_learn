public class TestMemberInner{
	public static void main(String[] args){
		Outer.Inner in1 = new Outer().new Inner();
		Outer.Inner in2 = new Outer().new Inner();
		Outer out = new Outer();
		Outer.Inner in3 = out.new Inner();
		Outer.Inner in4 = out.new Inner();
	}
}
class Outer{
	int a = 3;							//成员变量
	static int b = 5;					//静态变量

	class Inner{						//成员内部类
		int x = 7;
		public void test(){
			System.out.println(a);//okay
			System.out.println(b);//okay
			System.out.println(x);//okay
		}
	}
}


