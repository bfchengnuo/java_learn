public class ExecString{
	public static void main(String[] args){
		String str = "吃核桃不吐核桃皮 不吃核桃倒吐核桃皮";
		
		// 统计核桃出现的次数
		getSum4(str);
	}
	
	public static void getSum1(String str){
		int sum = 0;
		int flag = str.indexOf("核桃");
		while(flag != -1){
			sum++;
			flag = str.indexOf("核桃", flag + 1);
		}
		
		System.out.println(sum);
	}
	
	public static void getSum2(String str){
		// 关键字不能在最后
		// 保证字符串最后不是核桃
		String[] strs = (str+"a").split("核桃");
		System.out.println(strs.length - 1);
	}
	
	public static void getSum3(String str){
		// str = str.replaceFirst("核桃","");
		int sum = 0;
		while(str.contains("核桃")){
			sum++;
			str = str.replaceFirst("核桃","");
		}
		System.out.println(sum);
	}
	
	public static void getSum4(String str){
		int len1 = str.length();
		int len2 = str.replace("核桃","").length();
		System.out.println((len1 - len2)>>1);
	}
}