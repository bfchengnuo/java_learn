public class TestArrayCopy2{
	public static void main(String[] args){
		int[] data1 = new int[]{11,22,33};
		int[] data2 = new int[data1.length<<1];
		for(int i = 0;i<data1.length;i++){
			data2[i] = data1[i];
		}
		data1[0] = 100;
		System.out.println(data2[0]);//?
	}
}