public class TestCloneAgain{
	public static void main(String[] args)throws CloneNotSupportedException{
		Sheep s1 = new Sheep("肖恩");
		Sheep s2 = s1.clone();
	}
}
class Sheep implements Cloneable{//肖恩
	String name;
	public Sheep(String name){
		this.name = name;
	}
	@Override
	public Sheep clone()throws CloneNotSupportedException{
		Object obj = super.clone();//调用Object类的clone()方法
		return (Sheep)obj;
	}
}