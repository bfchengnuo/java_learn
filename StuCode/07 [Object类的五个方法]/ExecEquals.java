public class ExecEquals{
	public static void main(String[] args){
		Student s1 = new Student("Jay",16);
		Student s2 = new Student("Jay",16);
		//要求 通过覆盖equals()
		//让两个学生在名字和年龄都相同的情况下 视作相同 return true;
		System.out.println(s1.equals(s2));
	}
}
class Student{
	String name;
	int age;
	public Student(String name,int age){
		this.name = name;
		this.age = age;
	}
	@Override
	public boolean equals(Object obj){
		Student s1 = this;
		Student s2 = (Student)obj;
		return s1.name.equals(s2.name) && s1.age == s2.age;
	}
}