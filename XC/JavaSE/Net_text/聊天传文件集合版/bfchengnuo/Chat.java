package bfchengnuo;

import java.net.DatagramSocket;
import java.net.SocketException;

public class Chat {

	public void ChatStart() throws SocketException{
		//创建服务
		DatagramSocket send = new DatagramSocket();
		
		DatagramSocket rece = new DatagramSocket(10000);
		
		new Thread(new Chat_send(send)).start();
		new Thread(new Chat_rece(rece)).start();
	}
}
