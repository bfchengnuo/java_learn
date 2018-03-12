public class TestArraySort{
	public static void main(String[] args){
		int[] data = new int[]{53,87,66,39,14};
		//总共需要选多少个最大的数
		for(int i = 0;i<data.length-1;i++){
			//一次从头到尾的比较 = 选一个大数的过程
			for(int j = 0;j<data.length-1-i;j++){
				if(data[j] > data[j+1]){//前大后小
					int temp = data[j];
					data[j] = data[j+1];
					data[j+1] = temp;
				}
			}
		}
		for(int x : data){
			System.out.println(x);
		}

	}
}