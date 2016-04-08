//多线程基础学习
class DXC
{
	public static void main(String[] args)
	{
		ZX ls = new ZX();
		Thread t1 = new Thread(ls);
		Thread t2 = new Thread(ls);
		t1.start();
		t2.start();
	}
}

// 采用接口不妨碍继承
class ZX implements Runnable
{
	private int sum = 100;
	Object obj = new Object();
	public void run()
	{
		//不适用同步函数因为while不需要包含
		while (true)
		{
			
			synchronized(obj)  //同步锁  函数为this，静态为XXX.class，自解码文件
			{ //同步代码块
				if(sum <= 0)
					break;
				//因为调用了接口，无法抛出
				try
				{
					//确保有时间切换
					Thread.sleep(20);
				}
				catch(InterruptedException e)
				{
					//以后解决
				}
				System.out.println(Thread.currentThread().getName()+"......."+sum--);
			}
			
		}
		
	}
}