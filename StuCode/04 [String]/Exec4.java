public class Exec4{
	public static void main(String[] args){
		String str = "123je12je3k阿圣诞节快乐发123快a乐";
		//请尽你所能 统计 当中有多少个汉字
		System.out.println(str.getBytes().length - str.length());
		//多少个英文字母
		/*
		int zm = 0 , sz = 0;
		char[] data = str.toCharArray();
		for(char c : data){
			if('a'<=c && c<='z'){
				zm++;
			}else if('0' <= c && c<= '9' ){
				sz++;
			}
		}
		System.out.println(zm);
		System.out.println(sz);
		*/

		/*
		int zm = 0 , sz = 0;
		for(int i = 0;i<str.length();i++){
			char c = str.charAt(i);
			if('a'<=c && c<='z'){
				zm++;
			}else if('0' <= c && c<= '9' ){
				sz++;
			}
		}
		System.out.println(zm);
		System.out.println(sz);
		*/
		/*
		int old = str.length();
		String now = str.replaceAll("[a-z]","");
		int x = now.length();
		System.out.println(x - old);
		*/
		//多少个数字~
	}
}