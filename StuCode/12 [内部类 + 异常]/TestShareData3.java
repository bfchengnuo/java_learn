public class TestShareData3{
	public static void main(String[] args){
		¹ãº®¹¬ ghg = new ¹ãº®¹¬();
		¹ãº®¹¬.ÂÀ²¼ lxb = ghg.new ÂÀ²¼();
		¹ãº®¹¬.¶­×¿ ddz = ghg.new ¶­×¿();
		lxb.test();
		ddz.test();
	}
}
class ¹ãº®¹¬{
	Object õõ²õ = new Object();
	class ÂÀ²¼{
		public void test(){
			System.out.println(õõ²õ);
		}
	}
	class ¶­×¿{
		public void test(){
			System.out.println(õõ²õ);
		}
	}
}