package add;

public class Zhuangshi {

	public static void main(String[] args) {

		Person p = new Person();
//		p.eat();
		NewPerson p1 = new NewPerson(p);
		p1.eat();
	}

}

class Person {
	void eat(){
		System.out.println("吃饭");
	}

}

//这个类的出现就是为了增强person而出现
class NewPerson{
	//既然是为了增强就必须要有这个类
	private Person p;
	public NewPerson(Person p) {
		this.p = p;
	}
	
	public void eat(){
		System.out.println("开胃菜");
		p.eat();
		System.out.println("甜点");
	}
}

/*
 * 装饰设计模式：
	对一组对象的功能进行增强时，就可以使用该模式进行问题的解决。 
	

	装饰和继承都能实现一样的特点：进行功能的扩展增强。
	
	特点：装饰类和被装饰类都必须所属同一个接口或者父类。 
	
	如果进行多重继承  导致继承体系越来越臃肿。不够灵活。 
	*/
