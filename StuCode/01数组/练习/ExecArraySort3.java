public class ExecArraySort3{
	public static void main(String[] args){
		int[] data = {65, 128, 133, 68, 240, 55};
		
		for(int x = 0; x < data.length - 1; x++){
			for(int y = 0; y < data.length - 1 - x; y++){
				int t1 = data[y] > 100 ? data[y] : data[y] << 1;
				int t2 = data[y + 1] > 100 ? data[y + 1] : data[y + 1] << 1;
				if(t1 < t2){
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