public class TestValueOf{
	public static void main(String[] args){
		int num = 3;
		String s1 = num + "";//旁门左道 只是很好走
		String s2 = String.valueOf(num);//康庄大道 只是写得多
	}
}