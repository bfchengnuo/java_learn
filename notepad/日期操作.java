package cn.itcast.i18n;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class Demo2 {

	/**
	 * 
	 * 使用dateformat格式化输出日期
	 * @param args
	 */
	public static void main(String[] args) {

		Date date = new Date();
		
		// 只获取日期
		DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.CHINA);
		String str = df.format(date);
		System.out.println(str);
		
		// 只获取时间
		df = DateFormat.getTimeInstance(DateFormat.LONG, Locale.CHINA);
		System.out.println(df.format(date));
		
		
		// 获取全部
		df = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.SHORT, Locale.CHINA);
		System.out.println(df.format(date));
		
		
		//得到默认的dateformat
		df = DateFormat.getInstance();
		System.out.println(df.format(date));
		
		
		// 使用dateformat反向把一个字符串格式化成一个日期对象
		String str = "2011年3月25日 星期五 上午11:44";
		DateFormat df = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.SHORT, Locale.CHINA);
		Date date = df.parse(str);
		System.out.println(date);
		
		// 转数字
		int price = 18;   //$18  
		NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.JAPAN);
		System.out.println(nf.format(price));
		
		// 转百分比
		double d  = 0.1;
		nf = NumberFormat.getPercentInstance();
		System.out.println(nf.format(d));
		
		// 使用占位符，混合输出
		String pattern = "On {0}, a hurricance destroyed {1} houses and caused {2} of damage.";
		MessageFormat format = new MessageFormat(pattern,Locale.CHINA);
		Object params[] = {new Date(),99,1000000};
		String message = format.format(params);
		System.out.println(message);
	}

}
