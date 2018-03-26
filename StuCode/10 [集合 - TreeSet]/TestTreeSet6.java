import java.util.*;
public class TestTreeSet6{
	public static void main(String[] args){
		Set<Integer> set = new TreeSet<>();
		Collections.addAll(set,55,33,11,22,44);
		for(Iterator<Integer> car = set.iterator(); car.hasNext(); ){
			Integer x = car.next();
			if(x > 30){
				car.remove();
			}
		}
		System.out.println(set);
	}
}