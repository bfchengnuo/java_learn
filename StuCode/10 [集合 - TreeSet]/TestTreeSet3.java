import java.util.*;
public class TestTreeSet3{
	public static void main(String[] args){
		Set<Student> set = new TreeSet<>();
		Student s1 = new Student("Andy",60);
		Student s2 = new Student("Zorro",16);
		set.add(s1);
		set.add(s2);
		System.out.println(set);
	}
}
class Student implements Comparable<Student>{
	String name;
	int age;
	public Student(String name,int age){
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString(){
		return name + " : " + age;
	}
	@Override
	public int compareTo(Student stu){
		//找到两个参与比较的对象
		Student s1 = this;//新来的元素
		Student s2 = stu;//集合中的老元素
		/*
		if(s1.age > s2.age){//如果新元素的年龄 大于 老元素的年龄
			return 1;//把新来的放在右子树[后面]
		}else{//如果新元素的年龄 小于等于 老元素的年龄
			return -1;//把新来的放在左子树[前面]
		}
		*/
		return s1.name.compareTo(s2.name);
	}
}