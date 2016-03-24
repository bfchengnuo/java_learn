package net.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TransServer {

	public static void main(String[] args) throws IOException {

		/*
		 * 1,定义servicesocket服务
		 * 2，获取socket流/对象
		 * 3，创建缓冲区，打印，处理，返回
		 */
		
		//监听端口
		ServerSocket ss = new ServerSocket(10000);
		
		//获取流对象
		Socket s = ss.accept();
		
		//获取IP地址
		String ip = ss.getInetAddress().getHostAddress();
		System.out.println(ip+"........已连接");
		
		//获取读取流 并装饰
		BufferedReader bufr = new BufferedReader((new InputStreamReader(s.getInputStream())));//相当于客户端的output
		
		//获取输出流 并装饰
		PrintWriter pw = new PrintWriter(s.getOutputStream(),true); //相当于客户端的input
		
		String len = null;
//		如果客户端关闭了通道，相当于传了个-1就是null值
		while((len = bufr.readLine())!= null){
			System.out.println("已接收数据："+len);
			//转换大写的方法，并且写入流
			pw.println(len.toUpperCase());
		}
		s.close();
		ss.close();  //服务器一般不会关闭连接it
	}

}
