package Chat;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.HashMap;

import javax.swing.*;

public class Server extends JFrame implements ActionListener {
	public static HashMap<String, Socket> clients = new HashMap<String, Socket>();
	public ServerSocket server = null;

	private JLabel jlbMsg = new JLabel("服务器");
	private JTextField jtfrecive = new JTextField();
	private JTextField jtfmsg = new JTextField();
	private JTextArea jtaMsg = new JTextArea("消息接收器\r\n");
	private JButton jbt = new JButton("发送给客户端");

	public Server() {
		// TODO Auto-generated constructor stub
		this.setVisible(true);
		this.setSize(500, 680);
		this.setLayout(new FlowLayout());
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				super.windowClosing(arg0);
				try {
					server.close();
					System.exit(0);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		jtfrecive.setColumns(20);
		jtfmsg.setColumns(20);
		jtaMsg.setAutoscrolls(true);
		jtaMsg.setColumns(40);
		jtaMsg.setRows(30);
		jbt.addActionListener(this);

		JScrollPane spanel = new JScrollPane(jtaMsg);
		this.add(jlbMsg);
		this.add(jtfrecive);
		this.add(jtfmsg);
		this.add(jbt);
		this.add(spanel);
		init();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == jbt){
			String recive = jtfrecive.getText();
			String send = jtfmsg.getText();

			if (recive.split(" ").equals("") && send.split(" ").equals("")) {
				JOptionPane.showMessageDialog(null, "请输入要传输内容和接收方");
			} else {
				if(clients.containsKey(recive)){
					String speak = "<message from=””"
							+ " to=”" + recive + "”" + "  message=”" + send
							+ "”>";
					PrintWriter writer;
					try {
						writer = new PrintWriter(clients.get(recive).getOutputStream());
						writer.println(speak);
						writer.flush();
						jtaMsg.append("服务器向" + recive +"发送信息——>" + send);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else{
					jtaMsg.append("该用户不存在\r\n");
				}
			}
		}
	}

	public void init() {
		try {
			server = new ServerSocket(8888);
			System.out.println("服务器端已开启");
			while (true) {
				Socket socket = server.accept();
				new ServerThread(socket, this).start();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("服务器端已关闭");
		}
	}

	public void apppendMsg(String msg) {
		this.jtaMsg.append(msg + "\r\n");
	}

	public static void main(String[] args) {
		new Server();
	}
}