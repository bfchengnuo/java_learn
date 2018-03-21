import java.util.*;
public class TestArrayList3{
	public static void main(String[] args){
		List<Integer> list = new ArrayList<>();
		Collections.addAll(list,777,444,555,666);
		//É¾³ý444
		list.remove(new Integer(444));


		/*
		List<String> list = new ArrayList<>();
		Collections.addAll(list,"Jay","Andy","Aaron","Jacky","Leon");
		//ÇëÉ¾³ýÅ£µÂ»ª
		list.remove("Andy");
		list.remove("Jacky");
		*/
	}
}