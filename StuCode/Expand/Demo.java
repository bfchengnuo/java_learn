public class Demo{
	public static void main(String[] args){
		String s1 = "abc";
		String s2 = new String("abc");
		System.out.println(s1 == s2);
	}
	
	// 8 的倍数
	public static void num1(){
		for(int i = 8; i <= 100; i+=8){
			System.out.println(i);
		}
	}
	
	// 图形打印
	public static void num2(){
		for(int i = 0; i < 5; i++){
			for(int x = 0; x < 5; x++){
				if(x < i){
					System.out.print(" ");
				}else{
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
	
	// 图形打印
	public static void num3(){
		for(int i = 0; i < 5; i++){
			for(int x = 0; x < 5; x++){
				if(i == x){
					System.out.print("&");
				}else{
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
	
	// public static void num2(){
		// String str = "";
		// for(int i = 0; i < 5; i++){
			
			// System.out.println();
			// str += " ";
		// }
	// }
}
