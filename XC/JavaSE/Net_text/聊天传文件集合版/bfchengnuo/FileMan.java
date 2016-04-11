package bfchengnuo;

import java.io.IOException;
import java.util.Scanner;

public class FileMan {

	public void ShowSed() throws IOException {

		System.out.println("请输入要发送的文件位置和接收方的IP地址");

		Scanner in = new Scanner(System.in);
		String scr = in.nextLine();
		String ip = in.nextLine();

		new FileSend().Send(scr, ip);

	}

	public void ShowRed() throws IOException {
		System.out.println("请输入要接收的文件存放的位置和接收文件的后缀");

		Scanner in = new Scanner(System.in);
		String scr = in.nextLine();
		String suf = in.nextLine();

		new FileRece().Rece(scr, suf);
	}
}
