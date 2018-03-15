public class Exec5{
	public static void main(String[] args){
		String str = "刘亦菲:25,帕瓦罗蒂:60,柳岩:30"
			+ ",黄渤:40,郭德纲:55,林志颖:55";
		//请统计总共有多少个名字是三个字的明星
		{
			String[] data = str.split(",");
			for(String x : data){
				int index = x.indexOf(":");
				String n = x.substring(0,index);
				if(n.length() == 3){
					System.out.println(n);
				}
				/*
				String[] na = x.split(":");
				if(na[0].length() == 3){
					System.out.println(na[0]);
				}
				*/

			}
		}

		//请打印年龄40-60岁的明星
		{
			String[] data = str.split(",");
			//帕瓦罗蒂:60
			for(String x : data){
				String name = x.substring(0,x.indexOf(":"));
				String age = x.substring(x.indexOf(":")+1);
				if("60".equals(age) || age.startsWith("4") || age.startsWith("5")){
					System.out.println(name);
				}
			}
		}
	}
}