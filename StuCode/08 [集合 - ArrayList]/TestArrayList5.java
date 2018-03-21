import java.util.*;
public class TestArrayList5{
	public static void main(String[] args){
		List<Person> list = new ArrayList<>();
		Student stu = new Student("Bob");
		Teacher tea = new Teacher("Jay");
		list.add(tea);
		System.out.println(list.size());//1
		//请注意 中国法律当中有六个字 在这里完全符合
		//谁主张 谁举证
		list.remove(stu);//stu.equals(tea)
		System.out.println(list.size());//
	}
}
class Person{}
class Student extends Person{
	String name;
	public Student(String name){
		this.name = name;
	}
	@Override
	public boolean equals(Object obj){
		return true;
	}
}
class Teacher extends Person{
	String name;
	public Teacher(String name){
		this.name = name;
	}
	@Override
	public boolean equals(Object obj){
		return false;
	}
}