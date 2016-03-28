package regexIP;

public class RegexEmail {

	public static void main(String[] args) {

		//邮箱校验
		
		String em = "awdad@123.com";
		
		//X+一次或多次，后面封装为组，为了实现.com.cn之类的匹配  ，，｛｝出现次数为1次到3次
		String regex = "[a-zA-Z0-9_]+@[A-Za-z0-9]+(\\.[a-zA-Z]{1,3}){1,3}";
			//   \w 单词字符：[a-zA-Z_0-9]  上面的可以用\\w代替 
			
		boolean f = em.matches(regex);
		
		System.out.println(em +":"+ f);
	}

}
