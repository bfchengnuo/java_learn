public class TestFinally2{
	public static void main(String[] args){
		System.out.println(get(100));//1
		System.out.println(get(50));//2
		System.out.println(get(0));
		System.out.println(get(50));
		System.out.println(get(100));
	}
	public static int get(int x){
		try{
			return 100 / x;
		}catch(Exception e){
			System.out.println("吖！出事了吖！");
			return 0;
		}finally{
			//请注意 finally当中绝对不应该出现return语句！
			return 7777;
		}
	}
}