public class ExecShareData2{
	public static void main(String[] args){
		Object cola = new Object();
		Boy xm = new Boy(cola);
		Girl xh = new Girl(cola);
		xm.drink();
		xh.drink();
	}
}
class Boy{
	Object cola;
	public Boy(Object cola){
		this.cola = cola;
	}
	public void drink(){
		System.out.println(cola);
	}
}
class Girl{
	Object cola;
	public Girl(Object cola){
		this.cola = cola;
	}
	public void drink(){
		System.out.println(cola);
	}
}