public class TestArgs4{
	public static void main(String[] args){
		Student stu = new Student("Jay");//÷‹¿œ ¶
		change(stu);
		System.out.println(stu.name);//?
	}
	public static void change(Student x){
		//Student x = stu;
		x.name = "Gay";
		x = new Student("Gay");
	}
}
class Student{
	String name;
	public Student(String name){
		this.name = name;
	}
}