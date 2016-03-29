package web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Text {

	public static void main(String[] args) throws UnknownHostException, IOException {

		Socket s = new Socket("127.0.0.1", 8989);
		
		//获取键盘输入
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));

		//用于向服务器发送数据,用到了自动刷新
		PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
		
		
		//用于接收服务器的返回信息
		BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		String len = null;
		
		while((len = bufr.readLine()) != null){
			
			if("over".equals(len))
				break;
			
			pw.println(len);
			System.out.println(in.readLine());
		}
		
		
		s.close();
		
	}

}
