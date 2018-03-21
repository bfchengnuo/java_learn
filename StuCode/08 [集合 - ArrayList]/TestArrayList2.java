import java.util.*;
public class TestArrayList2{
	public static void main(String[] args){
		/*
		List<String> list = new ArrayList<>();
		Collections.addAll(list,"Jay","Andy","Aaron","Jacky","Leon");
		//请删除牛德华
		list.remove(1);
		//请删除张雪有
		list.remove(2);
		*/


		List<Integer> list = new ArrayList<>();
		Collections.addAll(list,1,2,3,4,5);
		//删除2
		//list.remove(1);

		//这样的写法无法删除所有元素
		for(int i = 0;i<list.size();i++){
			list.remove(i);
		}
		System.out.println(list.size());//2

		while(list.size() > 0){
			list.remove(0);
		}
		System.out.println(list.size());//0

		list.clear();
	}
}