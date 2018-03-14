public class ExecStringBuffer{
	public static void main(String[] args){
		String[] data = {"地球","亚洲","中国","山东","易途"};
		//请将字符串数组data当中的所有内容 追加连接成一个字符串
		StringBuffer okay = new StringBuffer();
		for(String x : data){
			okay.append(x);
		}
		System.out.println(okay);
	}
}