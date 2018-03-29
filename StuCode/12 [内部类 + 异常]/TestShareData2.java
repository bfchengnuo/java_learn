//利用传参完成数据共享
public class TestShareData2{
	public static void main(String[] args){
		Object 貂蝉 = new Object();

		吕布 lxb = new 吕布(貂蝉);
		董卓 ddz = new 董卓(貂蝉);
		lxb.test();
		ddz.test();
	}
}
class 吕布{
	Object 夫人;
	public 吕布(Object 夫人){
		this.夫人 = 夫人;
	}
	public void test(){
		System.out.println(夫人);
	}
}
class 董卓{
	Object 夫人;
	public 董卓(Object 夫人){
		this.夫人 = 夫人;
	}
	public void test(){
		System.out.println(夫人);
	}
}