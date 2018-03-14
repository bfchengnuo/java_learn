public class TestConstructor4{
	public static void main(String[] args){
		炒鸡蛋 cd1 = new 炒鸡蛋();//炒纯鸡蛋
		System.out.println("==============");
		炒鸡蛋 cd2 = new 炒鸡蛋("番茄");
	}
}
class 炒鸡蛋{
	public 炒鸡蛋(){
		System.out.println("开火 倒油 热锅");
		System.out.println("捣碎鸡蛋");
		System.out.println("不断翻炒");
	}
	public 炒鸡蛋(String 配菜){
		this();//在执行当前构造方法之前 先去执行本类的其它构造方法 而具体执行哪一个 取决于this()里面的参数
		System.out.println("放入"+配菜);
		System.out.println("继续不断翻炒");
	}
}


