public class ExecArraySort3{
	public static void main(String[] args){
		int[] data = {65,128,133,68,240,55};
		//已知 数组当中的元素代表一组同学的体重
		//而且 单位是不同的 100以下的都是公斤 100以上的都是斤
		//请按照提供由高到低降序排列
		for(int x = 0;x<data.length-1;x++){
			for(int y = 0;y<data.length-1-x;y++){
				int num1 = data[y] < 100 ? data[y]<<1 : data[y];
				int num2 = data[y+1] < 100 ? data[y+1]<<1 : data[y+1];
				if(num1 < num2){
					int temp = data[y];
					data[y] = data[y+1];
					data[y+1] = temp;
				}
			}
		}
		for(int x : data)
			System.out.println(x);
	}
}