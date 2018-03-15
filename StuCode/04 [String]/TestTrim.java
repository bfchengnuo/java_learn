public class TestTrim{
	public static void main(String[] args){
		String str = "         he rozk  ";
		System.out.println(str.length());
		String ok = str.trim();
		System.out.println(ok);
		System.out.println(ok.length());
	}
}