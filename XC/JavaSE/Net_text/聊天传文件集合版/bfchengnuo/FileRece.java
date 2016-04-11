package bfchengnuo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class FileRece {

	private static final int SIZE = 10485760;

	//路径和文件后缀
	public void Rece(String src,String suf) throws IOException {
		ServerSocket ss = new ServerSocket(10000);
		int count=0;
		Socket s = ss.accept();
		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip + "已连接");

		try {

			// 读取客户端发来的数据。
			InputStream in = s.getInputStream();

			// 将读取到数据存储到一个文件中。
			File dir = new File(src);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			File file = new File(dir, ip + suf);
			// 如果文件已经存在于服务端
			while (file.exists()) {
				file = new File(dir, ip + "(" + (++count) + ")"+suf);
			}

			FileOutputStream fos = new FileOutputStream(file);

			byte[] buf = new byte[SIZE];

			int len = 0;

			while ((len = in.read(buf)) != -1) {

				fos.write(buf, 0, len);
			}

			// 获取socket输出流，将上传成功字样发给客户端。
			OutputStream out = s.getOutputStream();
			out.write("上传成功".getBytes());

			fos.close();
			s.close();
		} catch (IOException e) {

		}
		
		
	}

}
