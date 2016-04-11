package bfchengnuo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class FileSend {

	private static final int SIZE = 10485760;//10M的缓冲区

	public void Send(String scr,String ip) throws UnknownHostException, IOException{
		
		Socket s = new Socket(ip,10000);
		FileInputStream file = new FileInputStream(scr);
		
		OutputStream out = s.getOutputStream();
		
		byte[] buf = new byte[SIZE];
		int len = 0;
		while((len = file.read(buf)) != -1){
			out.write(buf,0,len);
		}
		
		//告诉服务端已经发送完成停止读取
		s.shutdownOutput();
		
		InputStream in = s.getInputStream();
		
		byte[] bufin = new byte[1024];
		int lenin = in.read(bufin);
		System.out.println(new String(bufin,0,lenin));
		
		file.close();
		s.close();
	}
}
