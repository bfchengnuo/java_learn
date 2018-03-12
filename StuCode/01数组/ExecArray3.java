/*
	团团圆圆
	1  1  2  3  5  8  13  21  34 ..... 求数列的第19项
*/
public class ExecArray3{
	public static void main(String[] args){
		int[] panda = new int[19];
		panda[0] = 1;
		panda[1] = 1;
		/*
		panda[2] = panda[0] + panda[1];
		....
		panda[18] = panda[16] + panda[17];
		*/
		for(int x = 2;x<panda.length;x++){
			panda[x] = panda[x-2] + panda[x-1];//x[2-18]
		}
		System.out.println(panda[panda.length-1] << 1);
	}
}