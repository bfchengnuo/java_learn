import java.util.*;
public class TestAnonyInner{//TestTreeSet9.java
	public static void main(String[] args){
		Set<Integer> set = new TreeSet<>(new Comparator<Integer>(){
			@Override
			public int compare(Integer i1,Integer i2){
				return i2 - i1;
			}
		});
		Collections.addAll(set,55,33,11,44,22);
		//��Ҫ����
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
