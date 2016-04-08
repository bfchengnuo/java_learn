//异常基础应用

class YiChang
{
	public static void main(String[] args) throws AException,BException
	{
		data d = new data ("数据....");
		
		try
		{
			d.run(2);
		}
		catch(DException e)
		{
			System.out.println("没有成功写入");
		}
		finally
		{
			System.out.println("关闭数据库");
		}
		
		//测试嵌套异常
		BException cs = new BException("测试");
		cs.show();
	}
}

class data
{
	String s;
	boolean i;
	data(String s)
	{
		// i = true;
		i = false;
		this.s = s;
	}
	void run(int a) throws DException
	{
		 
		if(i)
			System.out.println("数据写入"+a);
		if(!i) 
			throw new DException("读取异常");
		 
	}
}

class DException extends Exception
{
	DException(String msg)
	{
		super(msg);
	}
}

class AException extends Exception
{
	AException(String s)
	{
		super(s);
	}
	//必须抛出
	/* 
	异常的注意事项：

	1，子类在覆盖父类方法时，父类的方法如果抛出了异常，
	那么子类的方法只能抛出父类的异常或者该异常的子类。

	2，如果父类抛出多个异常，那么子类只能抛出父类异常的子集。



	简单说：子类覆盖父类只能抛出父类的异常或者子类或者子集。 

	注意：如果父类的方法没有抛出异常，那么子类覆盖时绝对不能抛，就只能try .
	 */
	void show()throws AException,BException
	{
		
	}
}

class BException extends AException
{
	BException(String s)
	{
		super(s);
	}
	void show() throws AException,BException
	{
		throw new AException("测试");
	}
}

class CException extends Exception
{
	CException(){}
}