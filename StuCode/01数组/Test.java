public class Test{
	public static void main(String[] args){
		int x = 123;//data[y]   data[y+1]
		System.out.println(x / 100);//百位
		System.out.println(x / 10 % 10);//十位
		System.out.println(x % 10);//个位
		int s1 = (x / 100) + (x / 10 % 10) + (x % 10);
	}
}