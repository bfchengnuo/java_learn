import java.util.*;
public class ExecException{
	public static void main(String[] args){
		
		// ConcurrentModificationException  并发修改异常
		List<String> listss = new ArrayList<>();
		Collections.addAll(listss,"12","123","121");
		for(Iterator<String> car = listss.iterator(); car.hasNext(); ){
			String s = car.next();
			lists.add("344");
		}
		
		
		// IllegalStateException  非法状态异常
		List<String> lists = new ArrayList<>();
		Collections.addAll(lists,"12","123","121");
		Iterator<String> car = lists.iterator();
		car.remove();
		
		// IndexOutOfBoundsException   索引值超出边界异常
		List<String> list2 = new ArrayList<>(2);
		list2.get(2);
		
		// IllegalArgumentException  非法参数异常
		List<Integer> list = new ArrayList<>(-1);
		
		// ClassCastException   类造型异常
		Object o2 = "123";
		Integer inte = (Integer)o2;
		
		// NullPointerException   空指针异常
		Object o = null;
		o.toString();
		
		// NumberFormatException   数字格式异常
		int i2 = Integer.parseInt("123a");
		
		// StringIndexOutOfBoundsException  字符串索引值超出边界  substring
		char aa = "abc".charAt(4);
		
		// ArrayIndexOutOfBoundsException  数组索引值超出边界
		String str = "1 3".split(" ")[3];
		
		// NegativeArraySizeException  负数数组大小异常
		int[] a = new int[-1];
		
		// ArithmeticException  算数异常
		int x = 1/0;
	}
}