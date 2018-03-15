public class TestLastIndexOf{
	public static void main(String[] args){
		String str = "1a2a3a4a5a6a";//12a34a5
		System.out.println(str.lastIndexOf("a"));//3?
		System.out.println(str.lastIndexOf("a",6));//5?
		System.out.println(str.lastIndexOf("a",8));//7?
		System.out.println(str.lastIndexOf("a",10));//9?
	}
}