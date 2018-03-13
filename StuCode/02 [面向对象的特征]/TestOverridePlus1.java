public class TestOverridePlus1{
	public static void main(String[] args){
		After90 xiaoMing = new After90();
		xiaoMing.research();
	}
}
class After60{//60后
	public void research(){//研究
		System.out.println("去图书馆查阅资料");
		System.out.println("打电话咨询亲戚朋友");
	}
}
class After90 extends After60{//90后
	public void research(){
		super.research();//执行父类的research()方法
		System.out.println("百度一下 你就知道");
	}
}






