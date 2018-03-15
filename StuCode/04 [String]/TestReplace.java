public class TestReplace{
	public static void main(String[] args){
		String str = "Ётфоля╡╩мбфоляф╓";
		String ok = str.replace("фоля","╨клр");
		System.out.println(str);//фоля
		System.out.println(ok);//╨клр
	}
}