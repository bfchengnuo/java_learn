public class Exec3{
	public static void main(String[] args){
		String str = "370105198603091712";
		//请问 生日是几几年 几月 几日啊
		String year = str.substring(6,10);
		String month = str.substring(10,12);
		String date = str.substring(12,14);
		System.out.println(year + " - " + month + " - " + date);
		//请问 男的女的?
		String gender = str.substring(16,17);
		if("02468".contains(gender)){
			System.out.println("女的");
		}else{
			System.out.println("男的");
		}

	}
}