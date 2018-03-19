public class TestAbstract1{
	public static void main(String[] args){
		Animal kitty = new Cat();
		kitty.eat();
	}
}
abstract class Animal{//动物
	//动物一定有吃食物的方法 但是具体实现留待子类完成
	public abstract void eat();
}
class Cat extends Animal{//猫
	@Override
	public void eat(){
		System.out.println("猫吃猫粮");
	}
}
