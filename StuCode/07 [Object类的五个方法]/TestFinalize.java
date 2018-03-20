public class TestFinalize{
	public static void main(String[] args){
		while(true){
			Teacher tea = new Teacher("Jay");
			//如何主动的召唤gc
			System.gc();
			//Runtime.getRuntime().gc();
		}
	}
}
class Teacher{
	String name;
	public Teacher(String name){
		this.name = name;
		System.out.println("一个老师站起来~");
	}
	@Override
	public void finalize(){
		System.out.println("一个老师倒下去~");
	}
}