import java.util.*;
public class TestTreeSet5{
	public static void main(String[] args){
		Set<Student> set = new TreeSet<>();
		Student stu = new Student("Jay");
		set.add(stu);
		set.add(stu);
		set.add(stu);
		System.out.println(set.size());
		set.remove(stu);
		set.remove(stu);
		set.remove(stu);
		System.out.println(set.size());
		for(Iterator<Student> car = set.iterator(); car.hasNext(); ){
			Student x = car.next();
			if("Jay".equals(x.name)){
				car.remove();
			}
		}
		System.out.println(set.size());
	}
}
class Student implements Comparable<Student>{
	String name;
	public Student(String name){
		this.name = name;
	}
	@Override
	public int compareTo(Student stu){
		return 1;
	}
}