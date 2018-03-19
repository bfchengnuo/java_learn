public class ExecSingleton{
	public static void main(String[] args){
		//请使用你学过的知识 实现单例模式
		//要求 无论多少个同学尝试得到杯子
		//都得到相同的一个杯子
		Cup c1 = Cup.getOnly();
		Cup c2 = Cup.getOnly();
		System.out.println(c1 == c2);
	}
}
class Cup{//杯子
	private Cup(){}
	private static Cup only = new Cup();
	public static Cup getOnly(){
		return only;
	}
}