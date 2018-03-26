import java.util.*;
public class TestHashMap{
	public static void main(String[] args){
		Map<Student,Integer> map = new HashMap<>(16,0.75F);
		Student s1 = new Student("Jay");
		Student s2 = new Student("Gay");
		map.put(s1,100);
		System.out.println(map.get(s2));//?
		System.out.println(map.containsKey(s2));//?
		map.remove(s2);
		System.out.println(map.size());//0
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