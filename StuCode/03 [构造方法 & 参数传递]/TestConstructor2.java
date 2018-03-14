public class TestConstructor2{
	public static void main(String[] args){
		Teacher t1 = new Teacher();
		Teacher t2 = new Teacher("Jay",31);
	}
}
class Teacher{
	String name;
	int age;
	public Teacher(){
		System.out.println("你看我美吗?");
	}
	public Teacher(String name,int age){
		this.name = name;
		this.age = age;
		System.out.println("你看我丑吗?");
	}
}