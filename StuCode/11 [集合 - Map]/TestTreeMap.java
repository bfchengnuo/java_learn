import java.util.*;
public class TestTreeMap{
	public static void main(String[] args){
		Map<Student,String> map = new TreeMap<>(new StudentComparator());
		Student stu = new Student("Jay");
		map.put(stu,"√»√»ﬂ’~");
		map.put(stu,"≈÷≈÷ﬂ’~");
		System.out.println(map);//2
		System.out.println(map.get(stu));//?
		System.out.println(map.containsKey(stu));//false
		map.remove(stu);
		map.remove(stu);
		map.remove(stu);
		System.out.println(map.size());
	}
}
class StudentComparator implements Comparator<Student>{
	@Override
	public int compare(Student s1,Student s2){
		return 1;
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
}





