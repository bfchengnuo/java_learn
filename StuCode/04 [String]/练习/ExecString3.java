public class ExecString3{
	public static void main(String[] args){
		String str = "刘亦菲:25,帕瓦罗蒂:60,柳岩:30,黄渤:40,郭德纲:55,林志颖:55";
		String[] one = str.split(",");
		int name = 0;
		for(String x : one){
			String[] temp = x.split(":");
			if(temp[0].length() == 3){
				name++;
			}
			int tem = Integer.valueOf(temp[1]);
			// int a = new Integer(temp[1])    parseInt()
			// "45".contains(temp[1].substring(0,1)) || "60".equals(temp[1])
			// startsWith()
			if(tem >= 40 && tem <= 60){
				System.out.println(temp[0] + "--" + temp[1]);
			}
		}
		
		System.out.println(name);
	}
}