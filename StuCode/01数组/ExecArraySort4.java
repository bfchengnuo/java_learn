//笔试题原题
public class ExecArraySort4{
	public static void main(String[] args){
		char[] data = {'a','C','D','c','d','A','B','b'};
		//要求按照 A a B b C c D d进行排序~
		for(int x = 0;x<data.length-1;x++){
			for(int y = 0;y<data.length-1-x;y++){
				int num1 = data[y]<<1;//A 130  B 132
				int num2 = data[y+1]<<1;
				if(num1 > 193){
					num1 -= 63;
				}
				if(num2 > 193){
					num2 -= 63;
				}
				if(num1 > num2){
					char temp = data[y];
					data[y] = data[y+1];
					data[y+1] = temp;
				}
			}
		}
		for(char x : data){
			System.out.println(x);
		}
	}
}