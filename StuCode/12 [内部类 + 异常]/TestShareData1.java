//使用静态变量完成共享~
public class TestShareData1{
	public static void main(String[] args){
		//三国时期 司徒王允
		吕布 lxb = new 吕布();
		董卓 ddz = new 董卓();
		lxb.test();
		ddz.test();
	}
}
class 广寒宫{
	static Object 貂蝉 = new Object();
}
class 吕布{
	public void test(){
		System.out.println(广寒宫.貂蝉);
	}
}
class 董卓{
	public void test(){
		System.out.println(广寒宫.貂蝉);
	}
}