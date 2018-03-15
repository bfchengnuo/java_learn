public class TestGetBytes{
	public static void main(String[] args){
		String str = "ETOAK³¬ÔÞÅ¶";
		byte[] data = str.getBytes();
		System.out.println(data.length - str.length());
		/*
		for(byte x : data){
			System.out.println(x);
		}
		*/
	}
}