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

		System.out.println("客户端子线程" + this.getId() + "开始工作");
		while (true) {
			try {
				if (socket.isClosed() == false) {
					if (socket.isInputShutdown() == false) {
						temp = "服务器说——>" + ":" + reader.readLine();
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
				System.out.println("服务器已停止工作");
				System.exit(0);
			}
		}
	}
}
