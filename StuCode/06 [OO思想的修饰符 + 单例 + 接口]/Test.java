import java.util.*;
public class Test{
	public static void main(String[] args){
		StringBuffer ok = new StringBuffer();
		for(char x : str.toCharArray()){
			if(!ok.toString().contains(x+"")){
				ok.append(x);
			}
		}
		System.out.println(ok);
	}
}