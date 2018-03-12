public class ExecArray{
	public static void main(String[] args){
		char[] data = new char[]{'e', 't', 'o', 'a', 'k'};
		// char[] data1 = {64};
		// System.out.println(data1);
		
		System.out.println(data[2]);
		System.out.println(data[4]);
		
		System.out.println("======================");
	
		for(int i = 0; i < data.length; i++){
			System.out.println(data[i]);
		}
		
		System.out.println("======================");
		for(char x : data){
			System.out.println(x);
		}
	}
}