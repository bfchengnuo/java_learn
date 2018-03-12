public class ExecArrayCopy{
	public static void main(String[] args){
		int[] data = new int[]{53,87,66,39,14,29};
		//请通过数组复制的方法 删除39
		System.arraycopy(data,4,data,3,2);

		for(int x : data)
			System.out.println(x);
	}
}