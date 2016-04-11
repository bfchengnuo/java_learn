package bfchengnuo.reflect;

public class Text {

	public int num = 3;
	public Text(){
		System.out.println("这是空参构造函数");
	}
	
	public Text(String str){
		System.out.println("带有一个参数的构造函数");
	}
	
	public Text(String str,int i){
		System.out.println("带有两个参数的构造函数");
	}
	
	private Text(int i){
		System.out.println("这是私有的构造函数");
	}
	
//	函数部分演示
	
	public void show(){
		System.out.println("这是一个空参的函数");
	}
	
	public Class[] show(int i){
		System.out.println("这是一个有返回值，一个参数的函数");
		
		return new Class[]{int.class};
	}
	
	private void show(String str){
		System.out.println("这是一个私有的函数");
	}
}
