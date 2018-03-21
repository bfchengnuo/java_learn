import java.util.*;
public class TestArrayList6{
	public static void main(String[] args){
		List<Integer> list = new ArrayList<>();
		Collections.addAll(list,55,33,11,44,22);
		//请删除所有大于30的元素
		for(Iterator<Integer> car = list.iterator(); car.hasNext(); ){
			Integer x = car.next();
			if(x > 30){
				//list.remove(x);//ConcurrentModificationException
				car.remove();
			}
		}
		System.out.println(list);
	}
}