public class TestTryCatch{
	public static void main(String[] args){
		first();
	}
	public static void first(){
		second();
	}
	public static void second(){
		System.out.println("1st");
		try{
			new java.util.ArrayList<Integer>(-3);
		}catch(Exception e){
			//隐瞒不报
			//简要的审
			//System.out.println(e.getMessage());//简要描述信息
			//详细的审
			e.printStackTrace();
		}
		System.out.println("2nd");
	}
}
