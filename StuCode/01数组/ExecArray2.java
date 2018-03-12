public class ExecArray2{
	public static void main(String[] args){
		int[] data = new int[]{22,87,66,55,91,37};
		//请找出数组当中最大的和最小的元素...
		int max = 0,min = 99;
		for(int x : data){
			if(x > max){//破纪录了
				max = x;
			}
			if(x < min){//破纪录了
				min = x;
			}
		}
		System.out.println(max);
		System.out.println(min);
	}
}
