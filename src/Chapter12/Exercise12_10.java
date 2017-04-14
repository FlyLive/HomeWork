package Chapter12;

import java.awt.*;
import javax.swing.*;

import Chapter16.Exercise16_5;

public class Exercise12_10 extends JFrame{
	private JPanel back = new JPanel();
	
	public Exercise12_10(){
		back.setLayout(new GridLayout(8,8));
		
		for(int i = 1;i < 9;i++){
			for(int j = i;j < i + 8;j++){
				
				JButton white = new JButton();
				JButton black = new JButton();
		
				white.setBackground(Color.WHITE);		//设置颜色用Color.颜色大写
				black.setBackground(Color.BLACK);
				
				if(j % 2 != 0){
					back.add(white);
				}
				else{
					back.add(black);
				}
			}
		}
		add(back);
	}
	
	public static void main(String[] args){
		Exercise12_10 frame = new Exercise12_10();
		frame.setTitle("Exercise16_5");
		frame.setSize(400,400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
