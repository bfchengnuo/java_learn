public class ExecToString{
	public static void main(String[] args){
		Student s1 = new Student("小翔",60,20,80);
		Student s2 = new Student("小俐",100,60,100);
		Student s3 = new Student("小黑",500,100,100);//我家小狗
		System.out.println(s1);//小翔[良好]
		System.out.println(s2);//小俐[优秀]
		System.out.println(s3);//小黑[超赞]
		/*
			100 以下	渣渣
			100-200		良好
			200-299		优秀
			300			超赞
		*/
	}
}
class Student{
	String name;
	int chinese;
	int math;
	int english;
	public Student(String a,int b,int c,int d){
		name = a;
		chinese = b;
		math = c;
		english = d;
	}
	@Override
	public String toString(){
		/*
		StringBuffer ok = new StringBuffer(name);
		ok.append(" [").append(chinese+math+english).append("]");
		return ok.toString();
		*/
		//return name + " ["+(chinese + math + english) + "]";//60分
		int score = chinese + math + english;
		StringBuffer ok = new StringBuffer(name);
		ok.append(" [");
		String[] data = {"渣渣","良好","优秀","超赞"};
		int index = score / 100;//0-99
		if(index < 0 || index > data.length-1)
			throw new RuntimeException("考试成绩有bug 请申请重考");
		ok.append(data[index]).append("]");
		return ok.toString();
		/*
		int score = chinese + math + english;
		if(score < 100)
			ok.append("渣渣]");
		else if(score < 200)
			ok.append("良好]");
		else if(score < 300)
			ok.append("优秀]");
		else
			ok.append("超赞]");
		return ok.toString();
		*/


	}
}




