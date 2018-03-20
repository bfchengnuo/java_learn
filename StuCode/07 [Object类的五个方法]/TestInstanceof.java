/*
	∂‘œÛ instanceof ¿‡
*/
public class TestInstanceof{
	public static void main(String[] args){
		Bird poly = new Bird();
		System.out.println(poly instanceof Bird);
		System.out.println(poly instanceof Animal);
		System.out.println(poly instanceof Object);
		System.out.println(poly instanceof TuoBird);
		//System.out.println(null instanceof Object);
	}
}
class Animal{}
class Bird extends Animal{}
class Cat extends Animal{}
class TuoBird extends Bird{}