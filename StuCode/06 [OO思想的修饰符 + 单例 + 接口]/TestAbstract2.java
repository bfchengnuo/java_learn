public class TestAbstract2{
	public static void main(String[] args){

	}
}
abstract class Animal{
	public abstract void eat();
	public abstract void run();
}
abstract class Bird extends Animal{
	@Override
	public void eat(){
		System.out.println("鸟吃虫子");
	}
}
class TuoBird extends Bird{
	@Override
	public void run(){
		System.out.println("鸵鸟靠坚强有力的双腿奔跑");
	}
}







