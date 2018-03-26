import java.util.*;
public class TestTreeSet4{
	public static void main(String[] args){
		Set<Food> order = new TreeSet<>();
		Food f1 = new Food("斩青龙",18,1);
		Food f2 = new Food("雪盖火山",18,1);
		Food f3 = new Food("龙虎斗",256,2);
		Food f4 = new Food("果子狸炖水鱼",520,2);
		Food f5 = new Food("82年的雪碧",20,0);
		Food f6 = new Food("米饭",5,3);
		Collections.addAll(order,f1,f2,f3,f4,f5,f6);
		//售价高于50的菜品 1折优惠
		List<Food> temp = new LinkedList<>();
		for(Iterator<Food> car = order.iterator(); car.hasNext(); ){
			Food f = car.next();
			if(f.price > 50){
				car.remove();
				f.price /= 10;
				temp.add(f);//
			}
		}
		order.addAll(temp);

		//黄瓜缺货 请删除斩青龙
		//order.remove(f1);


		/*
		for(Iterator<Food> car = order.iterator(); car.hasNext(); ){
			Food f = car.next();
			if("斩青龙".equals(f.name)){
				car.remove();
			}
		}
		*/
		order.forEach(System.out::println);
	}
}
class Food implements Comparable<Food>{
	String name;//菜名
	int price;//价格
	int type;//类型 [0.酒水 1.凉菜 2.热菜 3.主食 4.汤品]

	private static String[] data = "酒水,凉菜,热菜,主食,汤品".split(",");

	public Food(String name,int price,int type){
		this.name = name;
		this.price = price;
		this.type = type;
	}
	@Override
	public String toString(){
		StringBuffer ok = new StringBuffer("[");
		ok.append(data[type]).append("] ").append(name).append(" : ").append(price).append("元");
		return ok.toString();
	}
	@Override
	public int compareTo(Food f){
		Food f1 = this;
		Food f2 = f;
		/*
			优先按照类别升序排列
			如果类别相同则按照价格降序排列
			如果类别和价格都相同 则按照名字排序
			如果都都都相同 也不能舍弃
		*/
		/*
		if(f1.type == f2.type){
			if(f1.price == f2.price){
				if(f1.name.equals(f2.name)){
					return 1;
				}else{
					return f1.name.compareTo(f2.name);
				}
			}else{
				return f2.price - f1.price;
			}
		}else{
			return f1.type - f2.type;
		}
		*/
		//易途的要求
		if(f1.type != f2.type)
			return f1.type - f2.type;
		if(f1.price != f2.price)
			return f2.price - f1.price;
		if(!f1.name.equals(f2.name))
			return f1.name.compareTo(f2.name);
		return 1;
	}
}