import java.util.*;
public class TestTreeSet8{
	public static void main(String[] args){
		Set<A> set = new TreeSet<>();
		A a1 = new A(1);
		set.add(a1);
		System.out.println("===============");
		A a2 = new A(2);
		set.add(a2);
		System.out.println("===============");
		A a3 = new A(3);
		set.add(a3);
		System.out.println("===============");
		A a4 = new A(4);
		set.add(a4);
		System.out.println("===============");
	}
}
class A implements Comparable<A>{
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
		System.out.println("新来的"+a1 + " vs 老元素" + a2);
		return a1.num - a2.num;
	}
}





