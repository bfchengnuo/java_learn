public class TestString{
	public static void main(String[] args){
		String s1 = "ETOAK";
		String s2 = "ETOAK";
		System.out.println(s1 == s2);//true

		String s3 = new String("ETOAK");
		String s4 = new String("ETOAK");
		System.out.println(s3 == s4);//false
	}
}