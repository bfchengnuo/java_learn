public class ExecArray2{
	public static void main(String[] args){
		int[] data = {22,87,66,55,91,37};
		// int max = 0,min=99;
		int max = data[0],min = data[0];
		
		/*
		for(int x = 1; x < data.length; x++){
			if(data[x] > max){
				max = data[x];
			}
			if(data[x] < min){
				min = data[x];
			}
		}
		
		System.out.println("max=" + max + ";min=" + min);
		*/
		
		for(int x : data){
			if(x > max){
				max = x;
			}
			
			if(x < min){
				min = x;
			}
		}
		
		System.out.println("max=" + max + ";min=" + min);
	}
}