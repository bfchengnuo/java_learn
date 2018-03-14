//Constructor = 构造方法
public class TestConstructor{
	public static void main(String[] args){
		Student stu = new Student("XiaoMing",18);
		System.out.println(stu.getName());
		System.out.println(stu.getAge());

	}
}
class Student{
	private String name;
	private int age;

	public Student(String name,int age){
		this.name = name;
		this.age = age;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}

	public void setAge(int age){
		this.age = age;
	}
	public int getAge(){
		return age;
	}

}