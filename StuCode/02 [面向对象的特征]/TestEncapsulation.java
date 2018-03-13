public class TestEncapsulation{
	public static void main(String[] args){
		Teacher tea = new Teacher();
		tea.setName("JayZhou");
		tea.setAge(31);

		System.out.println(tea.getName());
		System.out.println(tea.getAge());

		tea.teach();
	}
}
class Teacher{
	private String name;//每个老师都有自己的名字
	public void setName(String name){//setter
		this.name = name;
	}
	public String getName(){//getter
		return "亲爱的" + name + "老师";
	}

	private int age;//每个老师都有年龄
	public void setAge(int age){
		this.age = age;
	}
	public int getAge(){
		return age;
	}

	private void eat(){
		System.out.println("吃饱饱了才能好好讲课");
	}

	private void sleep(){
		System.out.println("睡好好了才能好好讲课");
	}

	private void play(){
		System.out.println("玩开心了才有心情好好讲课");
	}

	public void teach(){
		sleep();
		eat();
		play();
		System.out.println("我忘了只能原地奔跑的那悲伤 我也忘了自己是永远被锁上");
	}

}