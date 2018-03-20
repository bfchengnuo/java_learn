public class ExecClone{
	public static void main(String[] args)throws CloneNotSupportedException{
		Boyfriend xm = new Boyfriend("ะกร๗");
		Boyfriend xm2 = xm.clone();
	}
}
class Boyfriend implements Cloneable{
	String name;
	public Boyfriend(String name){
		this.name = name;
	}
	@Override
	public Boyfriend clone()throws CloneNotSupportedException{
		return (Boyfriend)(super.clone());
	}
}