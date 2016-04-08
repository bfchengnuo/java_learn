//多线程通讯等待唤醒
//使用lock


import java.util.concurrent.locks.* ;

class DHX2
{
	public static void main(String[] args)
	{
		Res ls = new Res();
		a set = new a(ls);
		b out = new b(ls);
		Thread t0 = new Thread(set);
		Thread t1 = new Thread(set);
		Thread t2 = new Thread(out);
		Thread t3 = new Thread(out);
		t0.start();
		t1.start();
		t2.start();
		t3.start();
	}
}

class Res
{
	private String name;
	private int s = 1;
	private boolean flag; //默认初始化false
	//创建一个锁
	Lock lock = new ReentrantLock();
	//创建两个监视器
	Condition loc1 = lock.newCondition();
	Condition loc2 = lock.newCondition();
	
	public void set(String name)
	{
		//换if，判断标记，解决线程唤醒后是否要运行
		lock.lock();
		try
		{
			while(flag)
			try
			{
				loc1.await();
			}
			catch(InterruptedException e){}
			//需要加this  本代码块也有this
			this.name = name +"-"+ s;	
			s++;
			System.out.println(Thread.currentThread().getName()+"发送......"+ this.name);
			
			flag = true;
			//释放其他线程锁
			loc2.signal();
		//这样写就不用写catch  = =
		}finally
		{
			//释放锁
			lock.unlock();
		}
		
	}
	
	public void outp()
	{
		lock.lock();
		try
		{
			while(!flag)
			try
			{
				loc2.await();
			}
			catch(InterruptedException e){}
			//也要加this 原因0.0 = =
			System.out.println(Thread.currentThread().getName()+"接收..........."+this.name);
			flag = false;
			loc1.signal();
		}finally
		{
			lock.unlock();
		}
		
	}
}

class a implements Runnable
{
	Res ls;
	a(Res ls)
	{
		this.ls = ls;
	}
	//覆盖接口的方法必须加public
	public void run()
	{
		while(true)
			ls.set("Loli");
	}
}

class b implements Runnable
{
	Res ls;
	b(Res ls)
	{
		this.ls = ls;
	}
	public void run()
	{
		while(true)
			ls.outp();
	}
}