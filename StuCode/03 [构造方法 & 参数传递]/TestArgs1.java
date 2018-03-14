public class TestArgs1{
	public static void main(String[] args){
		int num = 3;
		change(num);//num就是实际参数
		System.out.println(num);//?
	}
	public static void change(int x){//形式参数
		//方法的参数 等价于定义在方法体当中的局部变量
		//int x = num;
		x = 7;
	}//伴随着方法结束 方法体当中的局部变量立刻消亡
	 //而参数等价于局部变量 所以也消亡
}