import java.util.*;
public class TestTreeSet2{
	public static void main(String[] args){
		Set<String> set = new TreeSet<>();
		String str1 = new String("etoak");
		String str2 = new String("etoak");
		set.add(str1);
		set.add(str2);
		System.out.println(set.size());//?
		/*
		Set<Integer> set = new TreeSet<>();
		Integer num1 = new Integer(777);
		Integer num2 = new Integer(777);
		set.add(num1);
		set.add(num2);
		System.out.println(set.size());
		*/
	}
}