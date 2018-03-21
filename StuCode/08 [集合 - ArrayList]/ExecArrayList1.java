import java.util.*;
public class ExecArrayList1{
	public static void main(String[] args){
		String str = "Leon,Andy,Aaron,Jacky,Jay";
		/*
			请将五大天王 放入一个存放字符串的ArrayList集合当中
			并且使用各种不同的方式 遍历这个集合
			a>for + get()   b> foreach	JDK5.0
			c>Iterator	d> lambda表达式	JDK8.0
		*/
		String[] data = str.split(",");
		List<String> list = new ArrayList<>();
		Collections.addAll(list,data);//可变参数可以用数组来匹配
		for(int i = 0;i<list.size();i++){
			System.out.println(list.get(i));
		}
		for(String x : list){
			System.out.println(x);
		}
		for(Iterator<String> car = list.iterator(); car.hasNext(); ){
			String x = car.next();
			System.out.println(x);
		}
		list.forEach(System.out::println);

	}
}







