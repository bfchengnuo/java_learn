/*
关于进制的转换
格式：
jz(十进制数，转换的进制)
*/
class jinzhi
{
	public static void main(String[] args)
	{
		jz a = new jz();
		a.show(16,16);
		
		/* 不会返回数组
		int[] arr = jz(10,2);
		for(int i = 0;i < arr.length;i++)
			System.out.print(arr[i]); */
	}
	
}

class jz
{
	int [] arr = new int[15];
	char[] biao = {'0','1','2','3','4',
					'5','6','7','8',
					'9','A','B','C',
					'D','E','F'};
	int js = arr.length;
	
	void show(int x,int s)
	{
		if(s == 2)
			jzzh(x,1,1);
		else if(s == 8)
			jzzh(x,7,3);
		else if(s == 16)
			jzzh(x,15,4);
		else
			System.out.println(-1);
			//return -1;
	}
	void jzzh(int x,int y,int z)//x 原数 y 于的数 z 移动数
	{
		while(x != 0)
		{
			arr[--js] = x&y;
			x = x>>>z;
		}
		//打印一起写了吧
		for(int i = js;i < arr.length;i++)
		{
			System.out.print(biao[arr[i]]);
		}
	}
	
	
	
	
	  
	  //惨不忍睹的历史
	 /* 
	太麻烦了 啰嗦
	jz(int x,int s)
	{
		if(s == 2)
		{
			 jzs(x,s);
		}
		else if (s == 8)
		{
			 jzs(x,7);
		}
		else if(s == 16)
		{
			 jzs(x,15);
		}
		else
			return -1;
	} *
	void show()
	{
		 int [] arr = new int[15];
		int i;
		for(i = 0;x != 0;i++)
		{
			arr[i] = x&(s-1);
			x = x >>> 1;
			
		} 
		for( i = 14;i >= 0;i--)
			System.out.print(arr[i]);
	}
	void shows()
	{
		System.out.println("yes");
	}
	 */
}