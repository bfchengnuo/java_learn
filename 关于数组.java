class shuzu
{
	public static void main(String[] args)
	{
		
		
		int[] arr = {1,2,3};
		
		int[][] arr2 = new int[3][3];
		
		int[][] arr3 = new int[3][];  //可以这样定义
		arr3[0] = new int[3];
		arr3[1] = new int[2];
		
		System.out.println(arr3);
		System.out.println(arr3[0].length+arr3[1].length);
	}
}

/* 
int [] arr = new int []
int [] arr = new int [] {1,2}
int [] arr = {1,2,3}
arr.length   计算数组的长度

二维数组

int [][] arr = new int [2][3]
int [][] arr = new int [3][]
	arr[0] = new int [4]
	arr[0] = new int [5]  //不同的长度
int [][] arr = {{},{},{}}    一种初始化方式
	
直接打印数组名显示哈希值  [I@be880  @右边是哈希值，左边表示一个数组 int类型
int[][] arr = new int [2][]  打印arr[0]直接抛null

打印二维数字的长度，其实就是一维数组的个数 arr.length
打印元素个数  arr[1].length 
*/