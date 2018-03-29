public class TestThrows{
	//学生会主席
	public static void main(String[] args)throws Exception{
		first();
	}
	//各部门部长
	public static void first()throws Exception{
		second();
	}
	//各部门干事
	public static void second()throws Exception{
		Runtime.getRuntime().exec("notepad");
	}
}