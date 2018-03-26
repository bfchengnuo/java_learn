import java.util.*;
public class TestMap1{
	public static void main(String[] args){
		Map<String,Integer> map = new HashMap<>();
		map.put("小翔",210);//体育生
		map.put("小俐",160);//艺术生
		map.put("小黑",720);//我家小狗
		//keySet() : 得到所有主键对象组成的Set集合
		/*
			一个西瓜切两半 只拿左边那一半
			左边一半全是键 全部唯一且无序
		*/
		Set<String> ks = map.keySet();
		for(String k : ks){
			System.out.println(k + " = " + map.get(k));
		}
	}
}



