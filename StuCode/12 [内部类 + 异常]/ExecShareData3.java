public class ExecShareData3{
	public static void main(String[] args){
		Cinema etoak = new Cinema();
		Cinema.Boy jay = etoak.new Boy();
		Cinema.Girl gay = etoak.new Girl();
		jay.drink();
		gay.drink();
	}
}
class Cinema{
	Object cola = new Object();
	class Boy{
		public void drink(){
			System.out.println(cola);
		}
	}
	class Girl{
		public void drink(){
			System.out.println(cola);
		}
	}
}