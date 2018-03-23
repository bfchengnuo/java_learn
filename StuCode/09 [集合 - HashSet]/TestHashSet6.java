import java.util.*;
public class TestHashSet6{
	public static void main(String[] args){
		Set<Integer> set = new HashSet<>();
		Collections.addAll(set,55,33,44,11,22);
		for(Iterator<Integer> car = set.iterator(); car.hasNext(); ){
			Integer x = car.next();
			if(x > 30){
				car.remove();
			}
		}
		System.out.println(set);

	}
}