public class TestOverride{
	public static void main(String[] args){

	}
}
class Animal{
	public void eat(){
		System.out.println("动物吃食物的方法");
	}
}
class Cat extends Animal{
	public void eat(){
		System.out.println("猫吃猫粮");
	}
}
