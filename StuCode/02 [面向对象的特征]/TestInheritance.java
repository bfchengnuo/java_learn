public class TestInheritance{
	public static void main(String[] args){
		Dog babu = new Dog();//巴布豆
		babu.setName("Bob");
		babu.setAge(31);
		babu.eat();

		System.out.println(babu.getName());
		System.out.println(babu.getAge());
	}
}
class Animal{
	private String name;
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	private int age;
	public void setAge(int age){
		this.age = age;
	}
	public int getAge(){
		return age;
	}

	public void eat(){
		System.out.println("动物吃食物");
	}
}
class Dog extends Animal{//Dog是一种Animal

}

/*
class Car{}//汽车
class Person{}//人
class Transformer extends Car,Person{//类不支持多重继承//变形金刚 = 汽车人

}
*/