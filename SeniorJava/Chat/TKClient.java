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
			// �ӷ�������ȡ��������������(�ͻ��˽���)
			buffer_reader_temp = new BufferedReader(new InputStreamReader(
					temp.getInputStream()));
			// �ͻ��������(�ͻ��˷���)
			writer_temp = new PrintWriter(temp.getOutputStream());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			System.out.println("��ַ����");
			System.exit(0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("��������δ��");
			System.exit(0);
		}
		// �û�����
		input = new Scanner(System.in);

		boolean f = true;// ѭ���ж�
		int choice = 0;

		while (f) {
			System.out.print("��ѡ��:1.ע��  2.��¼  3.�˳�:");
			choice = input.nextInt();

			switch (choice) {
			case 1:
				registe();// ע��
				break;
			case 2:
				login();// ��¼
				break;
			case 3:
				f = false;
				break;// �˳�
			default:
				System.out.println("��������,����������");
				break;
			}
		}
	}

	public static void registe() throws Exception {
		System.out.print("ע����:");
		String speak = input.next();

		speak = "<register  name=��" + speak + "��/>";
		SendMessageToServer(speak);
	}

	public static void login() throws Exception {
		System.out.print("��¼��:");
		String speak = input.next();

		String clientName = speak;
		speak = "<login  name=��" + clientName + "��/> ";
		String result = SendMessageToServer(speak);
		if (result.startsWith("��¼�ɹ�")) {
			new Client(clientName,temp);
		}
	}

	public static String SendMessageToServer(String message) throws Exception {
		 writer_temp.println(message);
		 writer_temp.flush();
		 String response = buffer_reader_temp.readLine();
		 System.out.println("��������Ӧ:" + response);
		return response;
	}

}