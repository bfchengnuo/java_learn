public class TestSplit{
	public static void main(String[] args){
		String str = ",a,b,c";
		String[] data = str.split(",");
		System.out.println(data.length);


		/*
		String str = "Î÷¹Ï,Ïã½¶,²¤ÂÜ,»ğÁú¹û,ÁñÁ«,Æ»¹û";
		String[] data = str.split(",");
		for(String x : data){
			System.out.println(x);
		}
		*/

	}
}