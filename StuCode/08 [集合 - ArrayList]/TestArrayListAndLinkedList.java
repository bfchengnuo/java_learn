import java.util.*;
public class TestArrayListAndLinkedList{
	public static void main(String[] args){
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new LinkedList<>();
		for(int i = 0;i<100000;i++){
			list1.add(i);
			list2.add(i);
		}
		//long t1 = System.currentTimeMillis();
		long t1 = System.nanoTime();
		for(int i = 0;i<list1.size();i++){
			Integer x = list1.get(i);
		}
		//long t2 = System.currentTimeMillis();
		long t2 = System.nanoTime();
		System.out.println("ArrayList遍历十万元素:" + (t2 - t1)/1000/1000);

		long t3 = System.currentTimeMillis();

		for(int i = 0;i<list2.size();i++){
			Integer x = list2.get(i);
		}

		long t4 = System.currentTimeMillis();
		System.out.println("LinkedList遍历十万元素:" + (t4 - t3));
	}
}