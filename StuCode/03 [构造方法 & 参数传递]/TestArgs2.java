public class TestArgs2{
	public static void main(String[] args){
		int a = 3;
		int b = 5;
		change(a,b);
		System.out.println(a);//?
		System.out.println(b);//?
	}
	public static void change(int x,int y){
		int z = x;
		x = y;
		y = z;
	}
}