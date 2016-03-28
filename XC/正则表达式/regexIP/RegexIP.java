package regexIP;

import java.util.TreeSet;

public class RegexIP {

	public static void main(String[] args) {

		//对IP进行排序  
		
		String str = "192.1.5.4  5.6.44.7  103.112.3.5  11.54.6.1";
		
		//为了能让字符串进行比较  所以要设置为同一的位数
		//首先在每段前面补两个0，照顾不足3位的
		str = str.replaceAll("(\\d+)", "00$1"); //替换字符串的方法，X+一次或多次
		System.out.println(str);
		
		//然后去除多余的位数
		str = str.replaceAll("0*(\\d{3})", "$1");//x*是零次或多次
		System.out.println(str);
		
		// 利用之间的空格进行分割
		
		String[] ss = str.split(" +");
		
		//进行排序，利用treeset集合进行排序
		
		TreeSet<String> ts = new TreeSet<String>();
		
		for(String ip : ss){
			ts.add(ip);
		}
		
		//打印出来
		
		for(String ip : ts){
			//去掉多余的0只保留数字位
			System.out.println(ip.replaceAll("0*(\\d)", "$1"));
		}
	}

}
