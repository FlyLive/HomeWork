package Chapter12;

import java.awt.*;

import javax.swing.*;

public class Exercise12_9 extends JFrame{
	private ImageIcon first = new ImageIcon
			("D:/Important/JAVA/MyEclipse(Java³ÌÐò)/image/card/1.png");
	private ImageIcon second = new ImageIcon
			("D:/Important/JAVA/MyEclipse(Java³ÌÐò)/image/card/2.png");
	private ImageIcon third = new ImageIcon
			("D:/Important/JAVA/MyEclipse(Java³ÌÐò)/image/card/54.png");
	
	public Exercise12_9(){
		setLayout(new GridLayout(1,3,5,5));
		add(new JLabel(first));
		add(new JLabel(second));
		add(new JLabel(third));
	}
	
	public static void main(String[] args){
		Exercise12_9 frame = new Exercise12_9();
		frame.setTitle("Exercise12_9");
		frame.setSize(300,300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
}
