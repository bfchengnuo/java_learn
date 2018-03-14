public class TestArgs3{
	public static void main(String[] args){
		String a = new String("O");
		String b = new String("K");
		change(a,b);
		System.out.println(a);//?
		System.out.println(b);//?
	}
	public static void change(String x,String y){
		//String x = a;String y = b;
		String z = x;
		x = y;
		y = z;
	}
}