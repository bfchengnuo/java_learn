package bfchengnuo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Chat_rece implements Runnable{

	private DatagramSocket ds;
	
	public Chat_rece(DatagramSocket ds) {
		this.ds = ds;
	}
	
	@Override
	public void run() {

		try{
			while(true){
				//创建数据包,构造 DatagramPacket[数据报包]，用来接收长度为 length 的数据包。
				byte[] buf = new byte[1024];
				DatagramPacket dp = new DatagramPacket(buf, buf.length);
				
//				使用接收方法将数据存储到数据包中
				System.out.println("等待输入，输入close离开");
				ds.receive(dp);  //阻塞式，如果没有数据会一直阻塞
				
				//通过数据包对象方法 解析其中的数据
				
				//返回某台机器的 IP 地址，此数据报将要发往该机器或者是从该机器接收到的。
				String name = dp.getAddress().getCanonicalHostName();
				String ip = dp.getAddress().toString();
				int port = dp.getPort();//获取端口号
				String text = new String(dp.getData(),0,dp.getLength());//获取文本信息
				
				System.out.println("名:"+name+"  IP地址："+ip+"  端口："+port+"\n" +text);
				System.out.println("-----------------------------------------");
				
				if(text.equals("close")){
					
					System.out.println(ip+"已经退出聊天室");
				}
				
			}
		}catch(Exception e){
			
		}
	}

}
