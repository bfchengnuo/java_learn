package bfchengnuo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Chat_send implements Runnable{

	private DatagramSocket ds;
	
	public Chat_send(DatagramSocket ds){
		this.ds = ds;
	}

	@Override
	public void run() {

		try {
			BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
			String line = null;

			while ((line = bufr.readLine()) != null) {

				byte[] buf = line.getBytes();
				// 创建数据包，并且指定发送地址和端口，这里是广播地址
				// InetAddress此类表示互联网协议 (IP) 地址。getname 在给定主机名的情况下确定主机的 IP
				// 地址。也可以是IP地址，则仅检查地址格式的有效性。
				DatagramPacket dp = new DatagramPacket(buf,buf.length,InetAddress.getByName("192.168.1.255"),10000);

				ds.send(dp);// 将数据发送

				// 退出部分,退出循环
				if ("close".equals(line)) {
					System.out.println("你已退出聊天室");
					break;
				}

			}
			ds.close();
		} catch (Exception e) {
		}
	}
	
	
}
