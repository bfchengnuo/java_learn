public class TestObjectArray{
	public static void main(String[] args){
		Student[] et1803 = new Student[50];
		et1803[0] = new Student();
		for(Student x : et1803){
			System.out.println(x.name);//NullPointerException
		}
	}
}
class Student{
	String name;
	public void study(){
		System.out.println("GooDGooDSTuDY DaYDaYuP");
	}
}