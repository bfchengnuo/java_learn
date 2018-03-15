public class TestIndexOf{
	public static void main(String[] args){
		String str = "etoakoaoaoaoaoaoa";
		System.out.println(str.indexOf("oa"));//2
		System.out.println(str.indexOf("oa",3));//2

		int a = str.indexOf("oa");//第一次出现的位置
		int b = str.indexOf("oa",a+1);//第二次出现的位置
		int c = str.indexOf("oa",b+1);

		System.out.println(str.indexOf("oa",str.indexOf("oa",str.indexOf("oa")+1)+1));
		System.out.println(str.indexOf("oa",str.indexOf("oa",str.indexOf("oa")+1)+1));//2

	}
}