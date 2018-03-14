public class ExecConstructor3{
	public static void main(String[] args){
		Son no66 = new Son();
	}
}
class GrandFather extends Object{
	public GrandFather(){
		super();
		System.out.println("GrandFather");
	}
}
class Father extends GrandFather{
	public Father(){
		super();
		System.out.println("Father");
	}
}
class Son extends Father{
	public Son(){
		super();
		System.out.println("Son");
	}
}