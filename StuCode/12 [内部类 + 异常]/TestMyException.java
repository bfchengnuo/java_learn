public class TestMyException{
	public static void main(String[] args)throws Exception{
		int lucky = (int)(Math.random()*10);//0-9
		if(lucky == 4){
			throw new BJLException();
		}
		System.out.println("您的幸运数字是:"+lucky);
	}
}
class BJLException extends Exception{//自定义的一个异常
	public BJLException(){
		super("这个数字不吉利");
	}
}