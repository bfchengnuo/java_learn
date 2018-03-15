public class TestEquals{
	public static void main(String[] args){
		String str1 = new String("etoak");
		String str2 = new String("etoak");
		System.out.println(str1 == str2);
		System.out.println(str1.equals(str2));


		//如果要判断某个字符串是不是固定的内容
		//请将固定内容写在前面调用equals 防止空指针
		String str = null;
		if("ETOAK".equals(str)){
			System.out.println("验证成功");
		}else{
			System.out.println("验证失败");
		}
	}
}