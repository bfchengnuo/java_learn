public class TestClone extends Object{
	public static void main(String[] args)throws CloneNotSupportedException{
		Teacher t1 = new Teacher("Jay");
		Teacher t2 = t1.clone();
		System.out.println(t2.name);
	}
}
class Teacher implements Cloneable{//有能力被克隆的
	String name;
	public Teacher(String name){
		this.name = name;
	}
	@Override
	public Teacher clone()throws CloneNotSupportedException{
		return (Teacher)(super.clone());
	}
}





