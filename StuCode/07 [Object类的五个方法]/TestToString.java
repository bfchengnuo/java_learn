public class TestToString{
	public static void main(String[] args){
		String str = new String("etoak");
		System.out.println(str);//etoak
		System.out.println(str.toString());

		Student stu = new Student("Jay");
		System.out.println(stu);//Student@15db9742   运行时类别标识@内存地址映射值
		System.out.println(stu.toString());

		Student stu2 = new Student("Joshua");
		System.out.println(stu2);
	}
}
//尽管Student类没有写toString()
//但是会通过继承得到Object类的toString()
//而Object类的toString() 就是:运行时类别标识@内存地址映射值
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