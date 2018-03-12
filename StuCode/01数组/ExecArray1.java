public class ExecArray1{
	public static void main(String[] args){
		char[] data = new char[]{'e','t','o','a','k'};
		//请打印元素 o 和 k
		System.out.println(data[2]);
		System.out.println(data[4]);
		//请使用两种不同的方式 遍历这个数组
		for(int i = 0;i<data.length;i++){
			System.out.println(data[i]);
		}
		for(char x : data){
			System.out.println(x);
		}
	}
}