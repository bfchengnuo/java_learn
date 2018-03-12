public class TestArrayCopyFinalPlus{
	public static void main(String[] args){
		int[] data = new int[]{11,22,33,44,55};
		/*
		//不喜欢22 想要删掉它
		System.arraycopy(data,2,data,1,3);
		*/
		System.arraycopy(data,0,data,1,4);
		for(int x : data){
			System.out.println(x);
		}

	}
}