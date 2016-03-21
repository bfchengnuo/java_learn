package io_piped;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedDemo {

	public static void main(String[] args) throws IOException {
		// 管道流，，尽量配合多线程使用，避免死锁

		PipedInputStream input = new PipedInputStream();
		PipedOutputStream output = new PipedOutputStream();
		// 关联两个管道流,第一种方式，，还可以直接在new的时候直接传进去
		input.connect(output);

		// 如果是单线程，一个执行读，就没法写了，所以用多线程，，，mark
		new Thread(new Input(input)).start();
		new Thread(new Output(output)).start();
	}

}

// class写在外面  = =！

//Runnable 接口应该由那些打算通过某一线程执行其实例的类来实现。类必须定义一个称为 run 的无参数方法。
class Input implements Runnable {

	private PipedInputStream in;

	Input(PipedInputStream in) {
		this.in = in;
	}

	@Override
	public void run() {
		try {
			// 创建一个缓冲区
			byte[] buf = new byte[1024];
			// 将数据读进管道流，返回读入缓冲区的字节数
//			在输入数据可用、检测到流的末尾或者抛出异常前，此方法一直阻塞。
//			如果写入管道流没有数据就会一直等待
			int len = in.read(buf);
			String s = new String(buf, 0, len);
			System.out.println("s=" + s);
			// 关闭流
			in.close();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

class Output implements Runnable {
	private PipedOutputStream out;

	Output(PipedOutputStream out) {
		this.out = out;
	}

	@Override
	public void run() {
		try {
//			测试阻塞
			Thread.sleep(5000);
			// getBytes使用平台的默认字符集将此 String 编码为 byte 序列,返回一个byte数组
			out.write("管道流-----111".getBytes());

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
