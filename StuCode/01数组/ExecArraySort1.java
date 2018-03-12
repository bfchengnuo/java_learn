public class ExecArraySort1{
	public static void main(String[] args){
		int[] data = new int[]{53,87,66,39,14};
		//要求对数组进行冒泡排序 请降序排列
		for(int x = 0;x<data.length-1;x++){
			for(int y = 0;y<data.length-1-x;y++){
				if(data[y] < data[y+1]){
					data[y] = data[y] ^ data[y+1];
					data[y+1] = data[y] ^ data[y+1];
					data[y] = data[y] ^ data[y+1];
				}
			}
		}
		for(int x : data){
			System.out.println(x);
		}
	}
}