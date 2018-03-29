public class TestLocalInner{
	public static void main(String[] args){

	}
}
class Outer{
	int a = 3;
	static int b = 5;

	public void gogo(int c){
		int d = 7;
		class Inner{				//局部内部类
			int x = 9;
			public void test(){
				c = 3;
				System.out.println(a);//okay (如果gogo方法是静态的就不能)
				System.out.println(b);//okay
				System.out.println(c);//分版本
				System.out.println(d);//分版本
				System.out.println(x);//okay
			}
		};
		Inner in = new Inner();//有位置限定
	}
}





