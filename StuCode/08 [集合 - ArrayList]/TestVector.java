import java.util.*;
public class TestVector{
	public static void main(String[] args){
		//<Integer>泛型 JDK5.0特性
		//<> 泛型自动推断 钻石语法 JDK7.0特性
		List<Integer> list = new Vector<>();//如何创建集合对象
		//如何添加元素
		list.add(777);   //Integer.valueOf(111)
		list.add(444);
		list.add(555);
		list.add(666);
		//集合的工具类 Collections 当中提供一次添加多个元素的方法
		Collections.addAll(list,777,444,555,666);//往哪个集合里面添
		//如何得到元素个数
		System.out.println(list.size());//data.length
		//如何得到第几个元素
		System.out.println(list.get(0));//data[0]
		System.out.println("===============");
		//如何遍历
		//1st way : for + get()
		for(int i = 0;i<list.size();i++){
			System.out.println(list.get(i));
		}
		System.out.println("===============");
		//2nd way : foreach / forin
		for(Integer x : list){
			System.out.println(x);
		}
		System.out.println("===============");
		//3rd way : Iterator牌小推车...
		for(Iterator<Integer> car = list.iterator(); car.hasNext(); ){
			Integer x = car.next();
			System.out.println(x);
		}
		/*
		{
			Iterator<Integer> car = list.iterator();
			while(car.hasNext()){
				Integer x = car.next();
				System.out.println(x);
			}
		}
		*/
		System.out.println("===============");

		//4th way : lambda表达式 JDK8.0新特性
		list.forEach(System.out::println);
		System.out.println("===============");
		list.forEach(TestVector::kill);
	}
	public static void kill(Object obj){
		System.out.println(obj);
	}
}