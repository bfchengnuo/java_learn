public class ExecArraySort2{
	public static void main(String[] args){
		int[] data = {313,384,666,234,127,516};
		//请按照个位 + 十位 + 百位 三个数字的和升序排列
		for(int x = 0;x<data.length-1;x++){
			for(int y = 0;y<data.length-1-x;y++){
				int s1 = (data[y] / 100) + (data[y] / 10 % 10) + (data[y] % 10);
				int s2 = (data[y+1] / 100) + (data[y+1] / 10 % 10) + (data[y+1] % 10);
				if(s1 > s2){
					data[y] = data[y] + data[y+1];
					data[y+1] = data[y] - data[y+1];
					data[y] = data[y] - data[y+1];
				}
			}
		}
		for(int x : data)
			System.out.println(x);
	}
}