package bfchengnuo;

import java.io.IOException;
import java.util.Scanner;

public class Man {

	public static void main(String[] args) throws IOException {

		int i = 0;

		System.out.println("请输入你要进行的功能：");
		System.out.println("1-----进入聊天室");
		System.out.println("2-----发送文件");
		System.out.println("3-----接收文件");
		System.out.println("0-----退出程序");

//		while (true) {
			try {
				Scanner in = new Scanner(System.in);
				i = in.nextInt();
				
			} catch (Exception e) {
				System.out.println("请输入正确的指令！");
			}
//		}
		switch (i) {
		case 0:
			// 退出jvm
			System.exit(-1);
			break;
		case 1:
			new Chat().ChatStart();
			break;
		case 2:
			new FileMan().ShowSed();
			break;

		case 3:
			new FileMan().ShowRed();
			break;

		}
			
	}

}
