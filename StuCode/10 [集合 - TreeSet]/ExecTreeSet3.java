import java.util.*;
public class ExecTreeSet3{
	public static void main(String[] args){
		Set<Student> set = new TreeSet<>();
		Student s1 = new Student("小翔",80,60,80);
		Student s2 = new Student("小俐",60,80,80);
		Student s3 = new Student("小黑",100,100,100);
		Collections.addAll(set,s1,s2,s3);
		//并且要求按照三科平均分降序排列 注意 别丢人!
	}
}
class Student implements Comparable<Student>{
	String name;
	int yw;
	int sx;
	int yy;
	public Student(String name,int yw,int sx,int yy){
		this.name = name;
		this.yw = yw;
		this.sx = sx;
		this.yy = yy;
	}
	@Override
	public String toString(){
		return name + ": " + (yw + sx + yy);
	}
	@Override
	public int compareTo(Student stu){
		Student s1 = this;
		Student s2 = stu;
		int score1 = s1.yw + s1.sx + s1.yy;
		int score2 = s2.yw + s2.sx + s2.yy;
		return score1 == score2 ? 1 : score2 - score1;
	}
}