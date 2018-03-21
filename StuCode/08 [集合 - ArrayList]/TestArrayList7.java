import java.util.*;
/*
	ArrayList 扩容机制:
			JDK6.0及之前		JDK7.0及之后
			x*3/2+1				x+(x>>1)
*/
public class TestArrayList7{
	public static void main(String[] args){
		ArrayList<Integer> list = new ArrayList<>(3);
		list.add(777);
		list.add(444);
		list.add(555);
		//扩容
		list.ensureCapacity(20);
		//缩容
		list.trimToSize();
	}
}
/*
class ArrayList{
	private Object[] data;
	public ArrayList(int x){
		data = new Object[x];
	}
	public ArrayList(){
		this(10);
	}
}
*/