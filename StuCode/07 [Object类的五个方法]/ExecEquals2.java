public class ExecEquals2{
	public static void main(String[] args){
		Student s1 = new Student("Jay",60,80);
		Student s2 = new Student("Jay",70,70);
		//要求 通过覆盖equals()
		//让两个学生在名字和年龄都相同的情况下 视作相同 return true;
		System.out.println(s1.equals(s2));
	}
}
class Student{
	String name;
	int yw;
	int sx;
	public Student(String name,int yw,int sx){
		this.name = name;
		this.yw = yw;
		this.sx = sx;
	}
	@Override
	public boolean equals(Object obj){
		Student s1 = this;
		Student s2 = (Student)obj;
		int sum1 = s1.yw + s1.sx;
		int sum2 = s2.yw + s2.sx;
		return s1.name.equals(s2.name) && sum1 == sum2;
	}
}