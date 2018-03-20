public class TestEquals{
	public static void main(String[] args){
		/*
		Object obj1 = new Object();
		Object obj2 = new Object();
		System.out.println(obj1.equals(obj2));
		*/

		String str1 = new String("ABC");
		String str2 = new String("ABC");
		System.out.println(str1.equals(str2));//true

		Student stu1 = new Student("Jay");
		Student stu2 = new Student("Jay");
		System.out.println(stu1.equals(stu2));//false
	}
}
class Student{
	String name;
	public Student(String name){
		this.name = name;
	}
	@Override
	public boolean equals(Object obj){
		//只要是涉及到比较 不论比较是否相等 还是比较谁大谁小
		//首先就要找到参与比较的两个对象
		Student s1 = this;
		Student s2 = (Student)obj;
		//按照逻辑需求描述比较的内容
		return s1.name.equals(s2.name);
	}
}