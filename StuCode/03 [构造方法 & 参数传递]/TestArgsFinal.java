//Sun   SCJP  Sun Certified Java Programmer 2003.02.14
//Oracle OCJP  Oracle .....
public class TestArgsFinal{
	public static void main(String[] args){
		int num = 2;
		change(num);
		System.out.println(num);//2
		Int ok = new Int(num);
		change(ok);
		System.out.println(ok.i);//3
		changeRef(ok);
		System.out.println(ok.i);//3
	}
	public static void change(int x){
		x = 5;
	}
	public static void change(Int ia){
		ia.i = 3;
	}
	public static void changeRef(Int ia){
		ia = new Int(7);
	}
}
class Int{
	int i;
	public Int(int i){
		this.i = i;
	}
}