public class TestArrayCopy1{
	public static void main(String[] args){
		int[] data1 = new int[]{11,22,33};
		int[] data2 = data1;
		data2[0] = 100;
		System.out.println(data1[0]);//?
	}
}