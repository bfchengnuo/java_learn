import java.util.*;
public class TestArrayList9{
	public static void main(String[] args){
		List<Integer> list = new ArrayList<>(2);//黑色
		list.add(777);//蓝色
		list.add(444);//绿色
		list.add(555);//红色 [涉及扩容操作]
	}
}