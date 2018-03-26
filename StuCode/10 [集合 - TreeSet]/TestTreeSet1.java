import java.util.*;
public class TestTreeSet1{
	public static void main(String[] args){
		/*
		Set<String> set = new TreeSet<>();
		Collections.addAll(set,"Jay","Andy","Jacky","Aaron","Leon");
		System.out.println(set);
		*/

		TreeSet<Integer> set = new TreeSet<>();
		set.add(55);
		Collections.addAll(set,44,11,33,22,22,22,22,22);
		System.out.println(set);
		System.out.println(set.size());
		//尽管它是有序集合 但是依然不提供get(int)
		/*
		for(Iterator<Integer> car = set.iterator(); car.hasNext(); ){
			Integer x = car.next();
			System.out.println(x);
		}
		System.out.println("=====================");
		for(Integer x : set){
			System.out.println(x);
		}
		System.out.println("=====================");
		set.forEach(System.out::println);
		*/

		//first()  last()  pollFirst()  pollLast();
		System.out.println(set.first());
		System.out.println(set.last());

		while(set.size()!=0){
			System.out.println(set.pollFirst());
		}

	}
}







