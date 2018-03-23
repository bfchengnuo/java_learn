import java.util.*;
public class TestHashSet7{
	public static void main(String[] args){
		Set<Teacher> set = new HashSet<>();
		Teacher t1 = new Teacher("Jay");
		Teacher t2 = new Teacher("Gay");
		set.add(t1);
		System.out.println(set.size());
		set.remove(t2);
		System.out.println(set.size());
	}
}
class Teacher{
	String name;
	public Teacher(String name){
		this.name = name;
	}
	@Override
	public boolean equals(Object obj){
		return true;
	}
	@Override
	public int hashCode(){
		return 7;
	}
}