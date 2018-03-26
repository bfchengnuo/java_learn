import java.util.*;
public class TodaysHomework{
	public static void main(String[] args){
		//keySet() values() entrySet() Map.Entry
		//getKey() getValue() setValue()
		//size() remove() Iterator
		//完整的练习 Map集合的操作和字符串的处理 以及流程控制的内容
		TreeMap<Student,String> map = new TreeMap<Student,String>();
		Student s1 = new Student("昊昊",27);
		Student s2 = new Student("磊磊",24);
		Student s3 = new Student("龙龙",24);
		Student s4 = new Student("晖晖",27);
		Student s5 = new Student("超超",25);
		Student s6 = new Student("超超",22);
		Student s7 = new Student("嵩嵩",27);
		map.put(s1,"0531-66532154");
		map.put(s2,"0531-66666661");
		map.put(s3,"0532-88888888");
		map.put(s4,"0538-6678111");
		map.put(s5,"0531-55555511");
		map.put(s6,"0531-55555522");
		map.put(s7,"0538-3434596");
		//1st.打印当前通讯录总共收录了多少个联系人 0分
		System.out.println(map.size());
		//2nd.晖晖有个人生重要的考试 请假三天 暂时删除联系人 两种不同的方法实现
		//3rd.嵩嵩过生日了 已经28岁了 修改收录的年龄信息 一种做法
		//4th.泰安市发展迅速 电话号码升位 开头+8  0538
		//5th.请显示所有居住在济南的学生姓名
		//6th.打印所有同学所在的城市
		//7th.所有年龄低于25岁的同学 改用昵称 小X
	}
}
//请脱离开Student类制定Student类的比较规则
//这个规则要求 先按名字排序 名字相同按照年龄
//名字年龄都相同 则按照先来后到的顺序
class Student{
	String name;
	int age;
	public Student(String name,int age){
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString(){
		return name+":"+age;
	}
}