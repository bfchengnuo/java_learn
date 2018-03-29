import java.util.*;
public class TestAnonyInnerPlus{//TestTreeSet9.java
	public static void main(String[] args){
		Set<Integer> set = new TreeSet<>((x,y) -> y-x);
		Collections.addAll(set,55,33,11,44,22);
		//ÎÒÒª½µĞò
		System.out.println(set);
	}
}
/*
class IntegerDescComparator implements Comparator<Integer>{
	@Override
	public int compare(Integer i1,Integer i2){
		return i2 - i1;
	}
}
*/
