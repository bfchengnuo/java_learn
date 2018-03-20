public class TestHashCode{
	public static void main(String[] args){
		Student s1 = new Student("Bob",18);
		Student s2 = new Student("Bob",18);
		System.out.println(s1.equals(s2));
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
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
		if(obj == null) return false;
		if(!(obj instanceof Student)) return false;
		if(obj == this) return true;
		Student s1 = this;
		Student s2 = (Student)obj;
		return s1.name.equals(s2.name) && s1.age == s2.age;
	}
	@Override
	public int hashCode(){
		return name.hashCode() + age;
	}
}