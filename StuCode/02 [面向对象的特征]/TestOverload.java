public class TestOverload{
	public static void main(String[] args){
		System.out.println(55);
		System.out.println(true);
		System.out.println(5.5D);
		System.out.println(5.5F);

	}
	public static void test(){
		System.out.println("无参的test()");
	}
	public static void test(int x){
		System.out.println("int参数的test()");
	}
	/*
	public static void test(boolean isOkay,int num){

	}
	public static void test(int num,boolean isOkay){

	}
	*/
}