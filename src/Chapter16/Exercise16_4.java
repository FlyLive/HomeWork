package Chapter16;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Exercise16_4 extends JFrame{
	private JTextField jtfNumber1 = new JTextField(5);
	private JTextField jtfNumber2 = new JTextField(5);
	private JTextField result = new JTextField(5);
	
	private JButton jbtAdd = new JButton("Add");
	private JButton jbtSubtract = new JButton("Subtract");
	private JButton jbtMutiply = new JButton("Mutiply");
	private JButton jbtDivide = new JButton("Divide");
	
	private JPanel p1;
	private JPanel p2;
	
	public Exercise16_4(){
		setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
		draw1();
		draw2();
		add(p1);
		add(p2);
		
		jbtAdd.addActionListener(new ButtonListener());
		jbtSubtract.addActionListener(new ButtonListener());
		jbtMutiply.addActionListener(new ButtonListener());
		jbtDivide.addActionListener(new ButtonListener());
	}
	
	public void draw1(){
		this.p1 = new JPanel(new FlowLayout(FlowLayout.LEFT,10,10));
		p1.add(new JLabel("Number 1"));
		p1.add(jtfNumber1);
		p1.add(new JLabel("Number 2"));
		p1.add(jtfNumber2);
		p1.add(new JLabel("Result"));
		p1.add(result);
	}
	
	public void draw2(){
		this.p2 = new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));
		p2.add(jbtAdd);
		p2.add(jbtSubtract);
		p2.add(jbtMutiply);
		p2.add(jbtDivide);
	}
	
	private class ButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			double number1 = Double.parseDouble(jtfNumber1.getText());
			double number2 = Double.parseDouble(jtfNumber2.getText());
			
			if(e.getSource() == jbtAdd){
				result.setText("" + (number1 + number2));
			}
			else if(e.getSource() == jbtSubtract){
				result.setText("" + (number1 - number2));
			}
			else if(e.getSource() == jbtMutiply){
				result.setText("" + (number1 * number2));
			}
			else if(e.getSource() == jbtDivide){
				result.setText("" + (number1 / number2));
				
			}
		}
	}
	
	public static void main(String[] args){
		Exercise16_4 frame = new Exercise16_4();
		frame.setTitle("Exercise16_4");
		frame.setSize(450,180);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
