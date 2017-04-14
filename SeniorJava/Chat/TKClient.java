package Chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TKClient {
	private static Scanner input = null;
	private static Socket temp = null;
	private static BufferedReader buffer_reader_temp = null;
	private static PrintWriter writer_temp = null;

	public static void main(String[] args) throws Exception {
		try {
			temp = new Socket("127.0.0.1", 8888);
			// 从服务器获取服务器的输入流(客户端接收)
			buffer_reader_temp = new BufferedReader(new InputStreamReader(
					temp.getInputStream()));
			// 客户端输出流(客户端发送)
			writer_temp = new PrintWriter(temp.getOutputStream());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			System.out.println("地址错误");
			System.exit(0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("服务器尚未打开");
			System.exit(0);
		}
		// 用户输入
		input = new Scanner(System.in);

		boolean f = true;// 循环判断
		int choice = 0;

		while (f) {
			System.out.print("请选择:1.注册  2.登录  3.退出:");
			choice = input.nextInt();

			switch (choice) {
				case 1:
					registe();// 注册
					break;
				case 2:
					login();// 登录
					break;
				case 3:
					f = false;
					break;// 退出
				default:
					System.out.println("输入有误,请重新输入");
					break;
			}
		}
	}

	public static void registe() throws Exception {
		System.out.print("注册名:");
		String speak = input.next();

		speak = "<register  name=”" + speak + "”/>";
		SendMessageToServer(speak);
	}

	public static void login() throws Exception {
		System.out.print("登录名:");
		String speak = input.next();

		String clientName = speak;
		speak = "<login  name=”" + clientName + "”/> ";
		String result = SendMessageToServer(speak);
		if (result.startsWith("登录成功")) {
			new Client(clientName,temp);
		}
	}

	public static String SendMessageToServer(String message) throws Exception {
		writer_temp.println(message);
		writer_temp.flush();
		String response = buffer_reader_temp.readLine();
		System.out.println("服务器响应:" + response);
		return response;
	}

}