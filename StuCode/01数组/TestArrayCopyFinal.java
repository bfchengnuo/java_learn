public class TestArrayCopyFinal{
	public static void main(String[] args){
		int[] data1 = new int[]{11,22,33};
		int[] data2 = new int[data1.length<<1];
		System.arraycopy(data1,0,data2,0,data1.length);
	}
}