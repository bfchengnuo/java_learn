public class ExecShareData1{
	public static void main(String[] args){

	}
}
class Cinema{
	static Object cola = new Object();
}
class Boy{
	public void drink(){
		System.out.println(Cinema.cola);
	}
}
class Girl{
	public void drink(){
		System.out.println(Cinema.cola);
	}
}