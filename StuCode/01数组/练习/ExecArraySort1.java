public class ExecArraySort1{
	public static void main(String[] args){
		int[] data = {53, 87, 66, 39, 14};
		
		// 冒几次泡
		for(int i = 0; i < data.length - 1; i++){
			// 每次选举，需要比较几次
			for(int x = 0; x < data.length - 1 - i; x++){
				if(data[x] < data[x + 1]){
					data[x] = data[x] ^ data[x + 1];
					data[x + 1] = data[x] ^ data[x + 1];
					data[x] = data[x] ^ data[x + 1];
				}
			}
		}
		
		for(int x : data){
			System.out.println(x);
		}
	}
	
	/*
		交换两个变量（异或和加减只适用于整形）
		x = x + y;
		y = x - y;
		x = x - y;
		
	*/
}