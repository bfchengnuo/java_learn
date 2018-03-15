public class Exec1{
	public static void main(String[] args){
		String str = "³ÔºËÌÒ²»ÍÂºËÌÒÆ¤ ²»³ÔºËÌÒµ¹ÍÂºËÌÒÆ¤";
		//ÇëÍ³¼ÆºËÌÒ³öÏÖµÄ´ÎÊı...
		//1st way: split()
		String[] data = (str+"!").split("ºËÌÒ");
		System.out.println(data.length-1);
		//2nd way: replaceFirst() + while + contains()
		/*
		int count = 0;
		while(str.contains("ºËÌÒ")){
			str = str.replaceFirst("ºËÌÒ","ÆÏÌÑ");
			count++;
		}
		System.out.println(count);
		*/
		//3rd way: replace() + length()
		int len1 = str.length();
		str = str.replace("ºËÌÒ","â¨ºïÌÒ");
		int len2 = str.length();
		System.out.println(len2 - len1);










	}
}