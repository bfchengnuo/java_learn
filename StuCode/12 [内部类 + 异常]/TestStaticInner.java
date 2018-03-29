public class TestStaticInner{
	public static void main(String[] args){
		Outer.Inner in1 = new Outer.Inner();
		Outer.Inner in2 = new Outer.Inner();
	}
}
class Outer{
	int a = 3;
	static int b = 5;
	static class Inner{				//¾²Ì¬ÄÚ²¿Àà
		int x = 7;
		static int y = 9;
		public void test(){
			//System.out.println(a);//error
			System.out.println(b);//okay
			System.out.println(x);//okay
			System.out.println(y);//okay
		}
	}
}