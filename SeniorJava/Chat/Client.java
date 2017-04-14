package Chat;

import java.awt.FlowLayout;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.Scanner;

import javax.swing.*;

public class Client extends JFrame implements ActionListener {
	private String clientName = null;

	private ClientThread thread = null;
	private Socket client = null;
	private String host = "127.0.0.1"; // 要连接的服务端IP地址
	private int port = 8888; // 要连接的服务端对应的监听端口
	private PrintWriter writer = null;

	private JLabel jlbMsg = null;
	private JTextField jtfRecive = new JTextField();
	private JTextField jtfSend = new JTextField();
	private JTextArea jtaMsg = new JTextArea();
	private JButton jbtMsgSend = new JButton("发送消息");

	public Client(String name,Socket c) {
		// TODO Auto-generated constructor stub
		this.clientName = name;
		this.client = c;
		initSocket();

		jlbMsg = new JLabel("客户端消息接收器(" + clientName + ")");
		this.setVisible(true);
		this.setSize(550, 750);
		this.setResizable(false);
		this.setLayout(new FlowLayout());
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				super.windowClosing(arg0);
				try {
					if (client != null) {
						writer.println("<logout  name=”" + clientName + "”>");
						client.close();
					}

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (thread != null) {
					thread.stop();
				}
			}
		});

		jtfRecive.setColumns(20);
		jtfSend.setColumns(20);
		jbtMsgSend.addActionListener(this);

		jtaMsg.setColumns(40);
		jtaMsg.setRows(25);
		jtaMsg.setAutoscrolls(true);
		jtaMsg.disable();

		JScrollPane spanel = new JScrollPane(jtaMsg);

		this.add(jlbMsg);
		this.add(jtfRecive);
		this.add(jtfSend);
		this.add(jbtMsgSend);
		this.add(spanel);
	}

	public void initSocket() {
		try {
			// 客户端输出流(客户端发送)
			writer = new PrintWriter(client.getOutputStream());
			// 建立连接后就可以往服务端写数据了
			thread = new ClientThread(client, this);
			thread.start();
			this.appendMsg("已连上服务器");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			this.appendMsg("不能连接上服务器");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			this.appendMsg("不能连接上服务器");
		}
	}

	public void appendMsg(String msg) {
		this.jtaMsg.append(msg + "\r\n");
	}

	public String getClientName(){
		return this.clientName;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			if (e.getSource() == jbtMsgSend) {
				String recive = this.jtfRecive.getText();
				String send = this.jtfSend.getText();
				if (recive.split(" ").equals("") && send.split(" ").equals("")) {
					JOptionPane.showMessageDialog(null, "请输入要传输内容和接收方");

				} else {
					String speak = "<message from=”" + clientName + "”"
							+ " to=”" + recive + "”" + "  message=”" + send
							+ "”>";

					writer.println(speak);
					writer.flush();
					this.appendMsg("我(" + this.client.getLocalPort() + ")对"
							+ recive + "说——>" + send);
				}
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}