public class ExecArraySort2{
	public static void main(String[] args){
		int[] data = {313, 384, 666, 234, 127, 516};
		
		for(int x = 0; x < data.length - 1; x++){
			for(int y = 0; y < data.length - 1 - x; y++){
				int temp1 = (data[y] / 100) + (data[y] / 10 % 10) + (data[y] % 10);
				int temp2 = (data[y + 1] / 100) + (data[y + 1] / 10 % 10) + (data[y + 1] % 10);
				if(temp1 > temp2){
					data[y] = data[y] ^ data[y + 1];
					data[y + 1] = data[y] ^ data[y + 1];
					data[y] = data[y] ^ data[y + 1];
				}
			}
		}
		
		for(int x : data){
			System.out.println(x);
		}
	}
}