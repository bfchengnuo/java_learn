import java.util.*;
public class TestArrayList4{
	public static void main(String[] args){
		List<Student> et1803 = new ArrayList<>();
		Student s1 = new Student("Bob");
		Student s2 = new Student("Bob");
		et1803.add(s1);
		System.out.println(et1803.size());//1
		et1803.remove(s2);
		System.out.println(et1803.size());//0

		/*
		List<String> list = new ArrayList<>();
		String str1 = new String("etoak");
		String str2 = new String("etoak");
		list.add(str1);
		list.remove(str2);
		System.out.println(list.size());
		*/

		/*
		List<Integer> list = new ArrayList<>();
		Integer num1 = new Integer(222);
		Integer num2 = new Integer(222);
		list.add(num1);
		System.out.println(list.size());
		list.remove(num2);
		System.out.println(list.size());//?
		*/
	}
}
class Student{
	String name;
	public Student(String name){
		this.name = name;
	}
	@Override
	public boolean equals(Object obj){
		if(obj == null) return false;
		if(!(obj instanceof Student)) return false;
		if(obj == this) return true;
		Student s1 = this;
		Student s2 = (Student)obj;
		return s1.name.equals(s2.name);
	}
}