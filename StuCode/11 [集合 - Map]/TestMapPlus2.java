import java.util.*;
public class TestMapPlus2{
	public static void main(String[] args){
		Map<String,Integer> map = new HashMap<>();
		map.put("小翔",210);
		map.put("小俐",160);
		map.put("小黑",720);

		Set<String> ks = map.keySet();
		ks.remove("小翔");
		System.out.println(ks.size());//2
		System.out.println(map.size());//2

	}
}