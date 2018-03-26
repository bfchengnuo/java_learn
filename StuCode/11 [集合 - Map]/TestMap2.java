import java.util.*;
public class TestMap2{
	public static void main(String[] args){
		Map<String,Integer> map = new HashMap<>();
		map.put("小翔",210);//体育生
		map.put("小俐",160);//艺术生
		map.put("小黑",720);//我家小狗
		//values() : 得到所有值对象组成的Collection集合
		/*
			一个西瓜切两半 只拿右边那一半
			右边一半全是值 既不唯一又无序
		*/
		Collection<Integer> vs = map.values();
		for(Iterator<Integer> car = vs.iterator(); car.hasNext(); ){
			Integer x = car.next();
			System.out.println(x);
		}
	}
}



