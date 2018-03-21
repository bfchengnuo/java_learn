import java.util.*;
public class ExecArrayList6{
	public static void main(String[] args){
		List<String> list = new ArrayList<>();
		Collections.addAll(list,"周星驰","赵宏博","柳岩","刘德华","郭德纲","刘亦菲");
		//请删除所有名字是三个字的明星~
		for(Iterator<String> car = list.iterator(); car.hasNext(); ){
			String x = car.next();
			if(x.length() == 3){
				//list.remove(x);
				car.remove();
			}
		}
	}
}