public class ExecOverload{
	public static void main(String[] args){

	}
}
class A{
	private void gogogo(double num1,int num2){
		System.out.println("1st gogogo");
	}
	public int gogogo(int num1,double num2){
		System.out.println("2nd gogogo");
		return 777;
	}
}