import java.util.*;
public class TestHashSet2{
	public static void main(String[] args){
		Set<String> set = new HashSet<>();
		String str1 = new String("etoak");
		String str2 = new String("etoak");
		System.out.println(str1 == str2);//false
		set.add(str1);
		set.add(str2);
		System.out.println(set.size());//?
		/*
		Set<Integer> set = new HashSet<>();
		Integer num1 = new Integer(777);
		Integer num2 = new Integer(777);
		//num1和num2是内存当中完全不同的两个对象
		System.out.println(num1 == num2);//false
		set.add(num1);
		System.out.println(set.size());//1
		set.add(num2);
		System.out.println(set.size());//1
		*/
	}
}