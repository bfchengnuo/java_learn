package web;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class WebService {

	public static void main(String[] args) throws IOException {

		// 用于测试HTML的表单提交，搭建一个临时的服务器

		ServerSocket ss = new ServerSocket(8989);

		Socket s = ss.accept();

		// 获取一下连入的IP
		System.out.println(s.getInetAddress().getHostAddress() + "......已连接");

		// 获取客户端发送的内容
		InputStream in = s.getInputStream();

		// 给客户端的回应

		PrintWriter pw = new PrintWriter(s.getOutputStream(), true);

		byte[] but = new byte[1024];
		int len = 0;
		len = in.read(but);
		System.out.print(new String(but, 0, len));
		
		
//		pw.println("成功完成！");
		pw.println("<font color='red' size='7'>成功完成</font>");

		s.close();
		ss.close();
	}
}
