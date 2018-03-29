public class TestFinally{
	public static void main(String[] args){
		System.out.println("1st.");
		try{
			System.out.println(7/5);

		}catch(Exception e){
			e.printStackTrace();
			return;
		}finally{
			//无论是否出现异常 最终都要执行的操作
			//通常是释放和关闭资源的操作
			System.out.println("冲水");
		}

	}
}