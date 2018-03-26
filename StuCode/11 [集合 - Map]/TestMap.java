import java.util.*;
public class TestMap{
	public static void main(String[] args){
		//如何创建对象
		Map<String,Integer> map = new HashMap<>();
		//如何添加元素
		map.put("小翔",210);//体育生
		map.put("小俐",160);//艺术生
		map.put("小黑",720);//我家小狗
		//Map 没有Collections.putAll() 但是有map.putAll(另一个Map)
		//如何得到元素个数
		System.out.println(map.size());//3
		//最熟悉的陌生方法
		System.out.println(map.get("小黑"));//720
		//有一个方法分裂了 contains(obj)
		//判断是否包含指定的主键对象
		System.out.println(map.containsKey("小翔"));
		//判断是否包含指定的值对象
		System.out.println(map.containsValue(720));
		//如何删除一行键值对
		map.remove("小翔");
		System.out.println(map.size());
	}
}


