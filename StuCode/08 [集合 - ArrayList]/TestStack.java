import java.util.*;
//它是Vector的子类  栈 (LIFO = Last In First Out = 后进先出)
public class TestStack{
	public static void main(String[] args){
		Stack<Integer> stk = new Stack<>();
		stk.push(111);
		stk.push(333);
		stk.push(555);
		System.out.println(stk.pop());
		System.out.println(stk.pop());
		System.out.println(stk.pop());
	}
}