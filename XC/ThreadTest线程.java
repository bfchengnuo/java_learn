/*class Test implements Runnable
{
	public void run(Thread t)
	{}
}*/
//如果错误 错误发生在哪一行？错误在第一行，应该被abstract修饰
//如果run没有被覆盖，那就是一个抽象类  需要修饰符   接口也属于抽象类

class ThreadTest 
{
	public static void main(String[] args) 
	{

		new Thread(new Runnable()
		{
			public void run()
			{
				//任务
				System.out.println("runnable run");
			}
		})
		{
			public void run()
			{
				//子类为主
				//也许是因为子类可以覆盖
				System.out.println("subThread run");
			}
		}.start();


		/*
		匿名内部类
		new Thread()
		{
			public void run()
			{
				for(int x=0; x<50; x++)
				{
					System.out.println(Thread.currentThread().getName()+"....x="+x);
				}

			}
		}.start();
		
		主线程
		for(int x=0; x<50; x++)
		{
			System.out.println(Thread.currentThread().getName()+"....y="+x);
		}
		Runnable r = new Runnable()
		{
			public void run()
			{
				for(int x=0; x<50; x++)
				{
					System.out.println(Thread.currentThread().getName()+"....z="+x);
				}
			}
		};
		new Thread(r).start();

		*/
		
	}
}
