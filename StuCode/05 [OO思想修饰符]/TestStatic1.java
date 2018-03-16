public class TestStatic1{
	public static void main(String[] args){
		Student s1 = new Student("张三");
		Student s2 = new Student("李四");
		//张三倾尽一生 终于将自己的祖国建设成了 富强的中国
		Student.country = "富强的中国";
		System.out.println(Student.country);//?
		System.out.println(Student.country);//?
	}
}
class Student{
	String name;
	static String country = "中国";
	public Student(String name){
		this.name = name;
	}
}