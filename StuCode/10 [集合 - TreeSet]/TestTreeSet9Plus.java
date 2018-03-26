import java.util.*;
public class TestTreeSet9Plus{
	public static void main(String[] args){
		//JDK8.0新特性 lambda表达式
		Set<Integer> set = new TreeSet<>((a,b) -> b-a);
		Collections.addAll(set,55,33,11,44,22);
		//我要降序
		System.out.println(set);
	}
}
/*
class QQB implements Comparator<Integer>{
	@Override		//i1新来的 i2老元素
	public int compare(Integer i1,Integer i2){
		return i2 - i1;
	}
}
*/