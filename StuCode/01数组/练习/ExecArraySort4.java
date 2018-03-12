public class ExecArraySort4{
	public static void main(String[] args){
		char[] data = {'a','C','D','c','d','A','B','b'};
		
		// a 	b 	c	d        A
		// 97	98  99 100		65
		// 130  132
		// 194		63
		
		for(int x = 0; x < data.length - 1; x++){
			for(int y = 0; y < data.length - 1 - x; y++){
				// 如果小写，* 2 再 -63
				int t1 = data[y] > 96 ? (data[y] << 1) - 63 : data[y] << 1;
				int t2 = data[y + 1] > 96 ? (data[y + 1] << 1) - 63 : data[y + 1] << 1;
				if(t1 > t2){
					char temp = data[y];
					data[y] = data[y + 1];
					data[y + 1] = temp;
				}
			}
		}
		
		for(char x : data){
			System.out.print(x);
		}
	}
}