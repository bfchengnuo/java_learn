public class ExecArray4{
	public static void main(String[] args){
		boolean[] lights = new boolean[100];
		
		// 一百个人
		for(int i = 1; i <= 100; i++){
			// 一百个房间
			for(int x = i; x <= 100; x += i){
				// 一个人（当前这个人）去访问这些房间，看房间能否整除自己
				if(x % i == 0){
					lights[x - 1] = !lights[x - 1];
				}
			}
		}
		
		for(int x = 0; x < lights.length; x++){
			if(lights[x])
				System.out.println(x + 1);
		}
	}
}