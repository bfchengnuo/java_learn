public class TestPolymorphism2{
	public static void main(String[] args){
		/*
		Chinese xdd = new Chinese();
		American tlp = new American();
		Etoakese bob = new Etoakese();

		Restaurant kfc = new Restaurant();
		kfc.service(xdd);
		kfc.service(tlp);
		kfc.service(bob);
		*/

		Student bob = new Student();
		Teacher jay = new Teacher();
		Doctor bqe = new Doctor();
		Restroom wc = new Restroom();
		wc.service(bob);
		wc.service(jay);
		wc.service(bqe);
		Wumao wm = new Wumao();
		wc.service(wm);
	}
}
class Person{}
class Student extends Person{}
class Teacher extends Person{}
class Doctor extends Person{}
class Wumao extends Person{}
class Restroom{//Rest休息 Room房间 Restroom厕所 Toilet
	public void service(Person p){
		System.out.println("正常的上厕所...");
	}
}
/*
class Person{
	public void eat(){
		System.out.println("人类吃食物");
	}
}
class Chinese extends Person{//中国人
	public void eat(){
		System.out.println("中国人吃水饺");
	}
}
class American extends Person{//美国人
	public void eat(){
		System.out.println("美国人吃牛扒");
	}
}
class Japanese extends Person{//日本人
	public void eat(){
		System.out.println("日本人吃食物");
	}
}
class Etoakese extends Person{
	public void eat(){
		System.out.println("易途人吃满汉全席");
	}
}
class Restaurant{//餐厅
	public void service(Person xr){
		//Person xr = new Chinese();
		xr.eat();
	}
}
*/