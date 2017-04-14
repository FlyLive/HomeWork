package Chat;

import java.io.*;
import java.net.Socket;

public class ClientThread extends Thread {
	private Socket socket = null;
	private Client client = null;
	private BufferedReader reader = null;
	private String temp = "";

	public ClientThread(Socket socket, Client client) {
		// TODO Auto-generated constructor stub
		this.socket = socket;
		this.client = client;
		try {
			reader = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		System.out.println("�ͻ������߳�" + this.getId() + "��ʼ����");
		while (true) {
			try {
				if (socket.isClosed() == false) {
					if (socket.isInputShutdown() == false) {
						temp = "������˵����>" + ":" + reader.readLine();
						client.appendMsg(temp);
					}

				} else {
					if (socket.getKeepAlive() == false) {
						reader.close();
						socket.close();
						this.stop();
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("��������ֹͣ����");
				System.exit(0);
			}
		}
	}
}
