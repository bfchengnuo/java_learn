package net.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TransClient {

	public static void main(String[] args) throws UnknownHostException, IOException {

		// 客户端
		/*
		 * 1,创建一个socket服务，指定发送地址
		 * 2，定义一个IO流读取键盘输入
		 * 3，定义输出流发送数据，定义接收流用于接收服务器数据
		 */
		
		Socket s = new Socket("127.0.0.1", 10000);
		
		//因为是字符，所以用字符流，外加缓冲区
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		
		//定义一个打印流，方便发送数据,并且支持自动刷新   socket输出流。。。
		PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
		
		//定义一个输出流用于接收服务器数据， socket输入流。。。
		//同样是read，因为是读取服务器的返回数据
		BufferedReader bufin = new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		String len = null;
		
		while((len = bufr.readLine())!= null){
			//将数据发送给打印流
			if("over".equals(len))
				break;
//			要放在if下面，否则会抛异常，先传给服务器，服务器返回一个值但是客户端已经关闭了连接，所以会抛异常
			pw.println(len);
			System.out.println(bufin.readLine());
		}
		s.close();
	}

}
