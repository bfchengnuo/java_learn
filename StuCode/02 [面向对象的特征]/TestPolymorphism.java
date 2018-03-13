public class TestPolymorphism{
	public static void main(String[] args){
		Student bobo = new JavaStudent();
		bobo.study();//打印什么
	}
}
class Person{}//人类
class Student extends Person{//学生
	public void study(){
		System.out.println("好好学习 天天向上");
	}
}
class JavaStudent extends Student{//学Java的学生
	public void study(){
		System.out.println("敲代码的方法");
	}
}