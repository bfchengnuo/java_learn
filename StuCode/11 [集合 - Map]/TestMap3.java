import java.util.*;
public class TestMap3{
	public static void main(String[] args){
		Map<String,Integer> map = new HashMap<>();
		map.put("小翔",210);//体育生
		map.put("小俐",160);//艺术生
		map.put("小黑",720);//我家小狗
		//entrySet() : 得到所有键值对记录对象组成的Set集合
		Set<Map.Entry<String,Integer>> es = map.entrySet();
		for(Map.Entry<String,Integer> e : es){
			String k = e.getKey();
			Integer v = e.getValue();
			System.out.println(k + " = " + v);
			if("小黑".equals(k)){
				e.setValue(738);
			}
		}
	}
}