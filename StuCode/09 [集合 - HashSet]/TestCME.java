import java.util.*;
public class TestCME{
	public static void main(String[] args){
		List<Integer> set = new ArrayList<>();
		Collections.addAll(set,11,22,33,44,55);
		for(Iterator<Integer> car = set.iterator(); car.hasNext(); ){
			Integer x = car.next();
			if(x == 55){
				set.remove(x);
			}
		}
		System.out.println(set);
	}
}