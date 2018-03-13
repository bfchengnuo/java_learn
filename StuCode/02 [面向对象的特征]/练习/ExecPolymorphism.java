public class ExecPolymorphism{
	public static void main(String[] args){
		XCC xcc = new XCC();
		Benz b = new Benz();
		Bmw bmw = new Bmw();
		Jetta jetta = new Jetta();
		
		xcc.fix(b);
		// xcc.fix(bmw);
		// xcc.fix(jetta);
	}
}

class Car{
	public void run(){
		System.out.println("滴滴闷闷!!!!!!!!!");
	}
	public static void test(){
		System.out.println("test");
	}
}

class Benz extends Car{
	public void run(){
		System.out.println("Benz ... run");
	}
	public static void test(){
		System.out.println("aaaaaaaaaaa");
	}
}
class Bmw extends Car{
	public void run(){
		System.out.println("rrrrrrrrrrrr");
	}
}
class Jetta extends Car{
	public void run(){
		System.out.println("Jetta ... run...");
	}
}

class XCC{
	public void fix(Car car){
		System.out.println("fix car ok");
		car.run();
		car.test();
		System.out.println("-------------------");
		((Benz)car).test();
	}
}