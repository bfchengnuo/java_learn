public class TestReplaceFirst{
	public static void main(String[] args){
		String str = "Ётфоля╡╩мбфоляф╓";
		String ok = str.replaceFirst("фоля","╨клр");
		System.out.println(ok);
	}
}