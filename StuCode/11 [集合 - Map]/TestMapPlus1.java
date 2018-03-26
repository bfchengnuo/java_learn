import java.util.*;
public class TestMapPlus1{
	public static void main(String[] args){
		Map<Student,String> map = new HashMap<>();
		Student s1 = new Student("ETOAK");
		Student s2 = new Student("BDQN");
		map.put(s1,"ºÜÔüÅ¶~");
		map.put(s2,"³¬ÔŞÅ¶~");
		System.out.println(map);
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
	public boolean equals(Object obj){
		return true;
	}
	@Override
	public int hashCode(){
		return 1;
	}
}