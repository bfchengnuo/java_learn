
class text
{
	public static void main(String[] args)
	{
		int a = 3;
		a = ++a;
		System.out.println(a); //4
		int b = 3;
		//因为先运算右边，要等右边运算完左边才运算，所以建立一个临时空间存储b
		//等右边运算完后再把临时空间的值赋给b
		b = b++;
		System.out.println(b); //3
		int c = 3;
		System.out.println(c++);  //3
		System.out.println(c);  	//4
	}
}