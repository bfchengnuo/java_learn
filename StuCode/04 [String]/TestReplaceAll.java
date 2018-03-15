public class TestReplaceAll{
	public static void main(String[] args){
		String str = "asdj[a-z]f486asdf454as6dfa564";
		String s1 = str.replaceAll("[a-z]","");
		String s2 = str.replaceAll("[0-9]","");
		System.out.println(s1);
		System.out.println(s2);
		/*
		String str = "Ётфоля╡╩мбфоляф╓";
		String ok = str.replaceAll("фоля","╨клр");
		System.out.println(ok);
		*/
	}
}