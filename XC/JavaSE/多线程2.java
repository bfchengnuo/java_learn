//多线程通讯等待唤醒

class DHX
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
	
	public synchronized void set(String name)
	{
		//换if，判断标记，解决线程唤醒后是否要运行
		
		while(flag)
			try
			{
				wait();
			}
			catch(InterruptedException e){}
			//需要加this  本代码块也有this
		this.name = name +"-"+ s;	
		s++;
		System.out.println(Thread.currentThread().getName()+"发送......"+ this.name);
		
		flag = true;
		//避免发生死锁，省略this
		notifyAll();
	}
	
	public synchronized void outp()
	{
		while(!flag)
			try
			{
				wait();
			}
			catch(InterruptedException e){}
		//也要加this 原因0.0 = =
		System.out.println(Thread.currentThread().getName()+"接收..........."+this.name);
		flag = false;
		notifyAll();
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