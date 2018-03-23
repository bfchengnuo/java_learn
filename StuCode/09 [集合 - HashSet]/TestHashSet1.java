import java.util.*;
public class TestHashSet1{
	public static void main(String[] args){
		//如何创建集合
		Set<Integer> set = new HashSet<>();
		//如何添加一个元素
		set.add(11);
		set.add(33);
		//如何添加多个元素
		Collections.addAll(set,44,22,55,55,55,55,55,55);
		//如何得到元素个数
		System.out.println(set.size());//唯一
		//你要忘掉那个get(int)  => 无序
		//System.out.println(set.get(0));
		System.out.println("=============");
		//1st. Iterator
		for(Iterator<Integer> car = set.iterator(); car.hasNext(); ){
			Integer x = car.next();
			System.out.println(x);
		}
		System.out.println("=============");
		//2nd. foreach
		for(Integer x : set){
			System.out.println(x);
		}
		System.out.println("=============");
		//3rd. lambda 8.0
		set.forEach(System.out::println);
		//set.stream().filter(x -> x>30).forEach(System.out::println);


	}
}