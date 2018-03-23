import java.util.*;
public class ExecHashSet3{
	public static void main(String[] args){
		Set<Student> gyd = new HashSet<>();
		Student s1 = new Student("Ð¡Ã÷","AB");
		Student s2 = new Student("Baby","AB");
		gyd.add(s1);
		gyd.add(s2);
		System.out.println(gyd.size());
	}
}
class Student{
	String name;
	String blood;//ÑªÐÍ
	public Student(String name,String blood){
		this.name = name;
		this.blood = blood;
	}
	@Override
	public boolean equals(Object obj){
		if(obj == null) return false;
		if(!(obj instanceof Student)) return false;
		if(obj == this) return true;
		Student s1 = this;
		Student s2 = (Student)obj;
		return s1.blood.equals(s2.blood);
	}
	@Override
	public int hashCode(){
		return blood.hashCode();
	}
}