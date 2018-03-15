public class ExecString2{
	public static void main(String[] args){
		// String str = "name,age,salary";
		// String[] strs = str.split(",");
		// for(int i = 0; i < strs.length; i++){
			// String s = strs[i].substring(0,1).toUpperCase();
			// System.out.println("get" + s + strs[i].substring(1).toLowerCase() + "()");
			// System.out.println("set" + s + strs[i].substring(1) + "()");
		// }
		// System.out.println("国".getBytes().length);
		show3();
	}
	
	public static void show(){
		String str = "name,age,salary";
		String[] strs = str.split(",");
		for(int i = 0; i < strs.length; i++){
			String temp = String.valueOf(strs[i].charAt(0));
			String s = strs[i].replaceFirst(temp, temp.toUpperCase());
			System.out.println("get" + s + "()");
			System.out.println("set" + s + "()");
		}
	}
	
	/* 截取字符串练习 */
	public static void show2(){
		String str = "370105198603091712";
		
		String year = str.substring(6,10);
		String month = str.substring(10,12);
		String day = str.substring(12,14);
		
		System.out.println("年：" + year + "，月：" + month + "，日：" + day);
		// int age = Integer.valueOf(str.substring(str.length() - 3, str.length() - 1));
		char age = str.charAt(str.length() - 2);
		// "02468".contains(age);
		if((age & 1) == 0){
			System.out.println("性别：女");
		}else{
			System.out.println("性别：男");
		}
		// System.out.println()
	}
	
	/*
		统计字符串中汉字、字母、数字的个数
	*/
	public static void show3(){
		String str = "a211jkqkjqr212安静无2法43发我份";
		int sum =  str.getBytes().length;
		// int hSum = str.replaceAll("[0-9,a-z]","").getBytes().length >> 1;
		// 如果含有中文，字符数和字节数是不同的，注意编码
		int hSum = sum - str.length();
		int wSum = sum - str.replaceAll("[a-z]","").getBytes().length;
		
		System.out.println("汉字：" + hSum);
		System.out.println("英文字母：" + wSum);
		System.out.println("数字：" + (str.length() - wSum - hSum));

		// 第二种方式
		
		char[] chars = str.toCharArray();
		int hz = 0, zm = 0, sz = 0;
		for(char x : chars){
			if(x >= 'a' && x <= 'z'){
				zm++;
			}else if(x >= '0' && x <= '9'){
				sz++;
			}else{
				hz++;
			}
		}
		System.out.println(hz + " - " + zm + " - " + sz);
	}
}