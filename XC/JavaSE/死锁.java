class SiSuo
{
	public static void main(String[] args)
	{
		//因为是bool的所以创建两个对象了  省事
		Text a = new Text(true);
		Text b = new Text(false);
		Thread t1 = new Thread(a);
		Thread t2 = new Thread(b);
		t1.start();
		t2.start();
	}
}

class Text implements Runnable
{
	private boolean boo;
	//构造函数没有返回值标识符
	Text(boolean boo)
	{
		this.boo = boo;
	}
	public void run()
	{
		if(boo)
		{
			synchronized (MyLock.ck1)
			{
				System.out.println(Thread.currentThread().getName()+".....ck1");
				synchronized (MyLock.ck2)
				{
					System.out.println(Thread.currentThread().getName()+"....ck2");
				}
			}
		}
		else
			synchronized (MyLock.ck2)
			{
				System.out.println(Thread.currentThread().getName()+"....ck2");
				synchronized (MyLock.ck1)
				{
					System.out.println(Thread.currentThread().getName()+".....ck1");
				}
			}
	}
}

class MyLock
{
	//public final 再加
	static Object ck1 = new Object(); //总是忘加括号
	static Object ck2 = new Object();
	//变量是静态可以被类名调用
}