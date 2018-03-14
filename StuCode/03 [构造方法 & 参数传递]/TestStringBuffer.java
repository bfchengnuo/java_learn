//StringBuffer   append()    insert()    reverse()
public class TestStringBuffer{
	public static void main(String[] args){
		StringBuffer s2 = new StringBuffer();
		long t1 = System.currentTimeMillis();
		for(int i = 0;i<10000000;i++){
			s2.append(i);//append在预留的缓冲当中追加内容
		}
		long t2 = System.currentTimeMillis();
		System.out.println(t2 - t1);

		String s1 = "";
		//1970-01-01 00:00:00 000 -> 执行这行代码的时候
		long time1 = System.currentTimeMillis();
		for(int i = 0;i<100000;i++){
			s1 = s1 + i;
		}
		long time2 = System.currentTimeMillis();
		System.out.println(time2 - time1);
	}
}