public class TestVarargs{
	public static void main(String[] args){
		test(5);
		System.out.println("============");
		test(8);
		System.out.println("============");
		test(5,7);
		System.out.println("============");
		test(5,7,8);
		System.out.println("============");
		test();
		System.out.println("============");
		test(5,7,8,0);
	}
	//可变参数 ... 代表 int类型的0到无数个参数
	//一个方法最多有一个可变参数
	//可变参数 必须出现在参数列表的最后
	//不允许出现数组的等价定义
	public static void test(int ... data){
		for(int num : data){
			System.out.println(num);
		}
	}
}