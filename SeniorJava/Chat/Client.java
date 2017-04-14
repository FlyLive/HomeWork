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
	private String host = "127.0.0.1"; // Ҫ���ӵķ����IP��ַ
	private int port = 8888; // Ҫ���ӵķ���˶�Ӧ�ļ����˿�
	private PrintWriter writer = null;

	private JLabel jlbMsg = null;
	private JTextField jtfRecive = new JTextField();
	private JTextField jtfSend = new JTextField();
	private JTextArea jtaMsg = new JTextArea();
	private JButton jbtMsgSend = new JButton("������Ϣ");

	public Client(String name,Socket c) {
		// TODO Auto-generated constructor stub
		this.clientName = name;
		this.client = c;
		initSocket();

		jlbMsg = new JLabel("�ͻ�����Ϣ������(" + clientName + ")");
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
						writer.println("<logout  name=��" + clientName + "��>");
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
			// �ͻ��������(�ͻ��˷���)
			writer = new PrintWriter(client.getOutputStream());
			// �������Ӻ�Ϳ����������д������
			thread = new ClientThread(client, this);
			thread.start();
			this.appendMsg("�����Ϸ�����");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			this.appendMsg("���������Ϸ�����");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			this.appendMsg("���������Ϸ�����");
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
					JOptionPane.showMessageDialog(null, "������Ҫ�������ݺͽ��շ�");

				} else {
					String speak = "<message from=��" + clientName + "��"
							+ " to=��" + recive + "��" + "  message=��" + send
							+ "��>";

					writer.println(speak);
					writer.flush();
					this.appendMsg("��(" + this.client.getLocalPort() + ")��"
							+ recive + "˵����>" + send);
				}
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}