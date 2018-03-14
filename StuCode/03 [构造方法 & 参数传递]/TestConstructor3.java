public class TestConstructor3{
	public static void main(String[] args){

	}
}
class Person{
	String name;
	int age;
	//public Person(){}
	public Person(String name,int age){
		this.name = name;
		this.age = age;
	}
}
class Teacher extends Person{
	public Teacher(){
		super("孔子",2200);//默认就是super();
	}
}






