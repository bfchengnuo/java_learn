import java.util.*;
public class TestTreeSet7{
	public static void main(String[] args){
		Set<A> set = new TreeSet<>();
		//创业初期 由于资金紧张 我们选购了一辆A4
		A no1 = new A(4);
		set.add(no1);//把A4放进车库了
		//后来 公司蓬勃发展 我们选购了顶级豪华座驾
		A no2 = new A(8);
		set.add(no2);
		System.out.println(set);
		//后来 我们发现 5.2以上的车 真难停
		set.remove(no2);	//1.删除		当心TestTreeSet5
		no2.num = 3;		//2.修改
		set.add(no2);		//3.重新添加	当心TestTreeSet6
		System.out.println(set);//?
	}
}
class A implements Comparable<A>{//奥迪的一个系列   A4 A5 A6 A7 A8
	int num;
	public A(int num){
		this.num = num;
	}
	@Override
	public String toString(){
		return String.valueOf(num);
	}
	@Override
	public int compareTo(A a){
		A a1 = this;
		A a2 = a;
		return a1.num - a2.num;
	}
}


