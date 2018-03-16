public class TestStatic2{
	public static void main(String[] args){
		Student s1 = new Student("ÕÅÈı");
		Student s2 = new Student("ÀîËÄ");
		s1.singASong();
		Student.cleanClassroom();
	}
}
class Student{
	String name;
	public Student(String name){
		this.name = name;
	}
	public void singASong(){
		System.out.println(name + "Ï´Ë¢Ë¢ Ï´Ë¢Ë¢ Å¶Å¶~");
	}
	public static void cleanClassroom(){
		System.out.println("Ò»ÉÁÒ»ÉÁÁÁ¾§¾§~");
	}
}

