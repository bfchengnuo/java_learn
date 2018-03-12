public class ExecArray3{
	public static void main(String[] args){
		int[] panda = new int[19];
		panda[0] = 1;
		panda[1] = 1;
		
		for(int x = 2; x < panda.length; x++){
			panda[x] = panda[x - 2] + panda[x - 1];
		}
		
		// System.out.println(panda[panda.length - 1]);
		
		// 1 1 2 3 5
		
		System.out.println(show(1,1));
	}
	
	static int temp = 0;
	static int flag = 3;
	public static int show(int x, int y){
		 temp = x + y;
		 if(flag++ == 19){
			 return temp;
		 }
		 return show(y,temp);
	}
}