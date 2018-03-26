import java.util.*;
//比较器 并不是TreeSet自己的专利
//即便不用TreeSet 也可能会用比较器
public class TestComparatorPlus{
	public static void main(String[] args){
		List<Integer> list = new ArrayList<>();
		Collections.addAll(list,55,33,11,44,22);
		//我想排序
		//Collections.sort(list);
		//System.out.println(list);
		//我要降序
		//Collections.reverse(list);//翻转元素
		//System.out.println(list);
		Collections.sort(list,(x,y) -> y-x);
		System.out.println(list);
	}
}
/*
class TP implements Comparator<Integer>{
	@Override
	public int compare(Integer i1,Integer i2){
		return i2 - i1;
	}
}
*/