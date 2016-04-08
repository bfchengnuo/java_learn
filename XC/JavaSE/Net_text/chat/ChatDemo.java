package netDemo;

import java.net.DatagramSocket;
import java.net.SocketException;

public class ChatDemo {

	public static void main(String[] args) throws SocketException {

		//创建服务
		DatagramSocket send = new DatagramSocket();
		//绑定到本地主机上的指定端口!!!
		DatagramSocket rece = new DatagramSocket(10000);
		
		//传入，并且开启多线程
		new Thread(new Send(send)).start();
		new Thread(new Rece(rece)).start();
		
	}

}
