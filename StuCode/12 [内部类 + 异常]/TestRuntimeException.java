import java.util.*;
public class TestRuntimeException{
	public static void main(String[] args){
		//IllegalStateException => 非法状态异常
		List<Integer> list3 = new ArrayList<>(3);
		Collections.addAll(list3,11,22,33);
		Iterator<Integer> car = list3.iterator();
		car.remove();

		//IndexOutOfBoundsException => 索引值超出边界异常
		List<Integer> list2 = new ArrayList<>(3);
		Collections.addAll(list2,11,22,33);
		System.out.println(list2.get(3));//?

		//IllegalArgumentException => 非法参数异常
		List<Integer> list1 = new ArrayList<>(-3);
		//ClassCastException => 类造型异常
		Object stu = new Student();
		Cacti cc = (Cacti)stu;
		//NullPointerException => 空指针异常
		String str3 = null;
		System.out.println(str3.length());
		//NumberFormatException => 数字格式异常
		String str2 = "123a";
		int price = Integer.parseInt(str2);
		System.out.println(price+3);
		//StringIndexOutOfBoundsException => 字符串索引值超出边界异常
		String str1 = "etoak";
		System.out.println(str1.charAt(5));
		System.out.println(str1.substring(0,10));
		//ArrayIndexOutOfBoundsException => 数组索引值超出边界异常
		int[] data2 = new int[]{1,2,3};
		System.out.println(data2[3]);
		//NegativeArraySizeException => 负数数组大小异常
		int[] data1 = new int[-3];
		//ArithmeticException => 算术异常
		System.out.println( 5 / 0 );
	}
}
class Student{}
class Cacti{}//仙人球 仙人掌