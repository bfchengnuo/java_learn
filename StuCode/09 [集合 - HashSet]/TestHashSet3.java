import java.util.*;
public class TestHashSet3{
	public static void main(String[] args){
		Set<Student> set = new HashSet<>();
		Student s1 = new Student("Jay");
		Student s2 = new Student("Jay");
		set.add(s1);
		set.add(s2);
		System.out.println(set.size());//
	}
}
class Student{
	String name;
	public Student(String name){
		this.name = name;
	}
	@Override
	public String toString(){
		return name;
	}
	@Override
	public int hashCode(){
		return name.hashCode();
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