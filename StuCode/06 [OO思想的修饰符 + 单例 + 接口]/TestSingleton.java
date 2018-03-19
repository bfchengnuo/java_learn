public class TestSingleton{
	public static void main(String[] args){
		/*
		Sun s1 = Sun.getOnly();
		Sun s2 = Sun.getOnly();
		System.out.println(s1 == s2);//?
		*/
	}
}
//懒汉式 = 延迟加载
class Sun{
	private Sun(){}
	private static Sun only;//null
	public static Sun getOnly(){
		if(only == null)
			only = new Sun();
		return only;
	}
}

/*
//醉汉式
class Moon{
	//私有化构造方法 防止类体之外随意new对象
	private Moon(){}
	//在本类当中创建一个当前类型的对象 应该是私有的静态的
	private static Moon only = new Moon();
	//在本类当中提供一个公共的 静态的getter
	public static Moon getOnly(){
		return only;
	}
}
*/

/*
class Sun{
	//1st.私有化它的构造方法 防止类体之外随意创建对象
	private Sun(){}
	//2nd.在本类类体当中提供一个本类对象
	private static Sun only = new Sun();
	//3rd.为这个唯一的私有属性提供getter方法
	public static Sun getOnly(){//getter
		return only;
	}
}
*/



