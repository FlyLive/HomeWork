package Chapter16;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Exercise16_5 extends JFrame{
	private JPanel p1;
	private JPanel p2;
	
	private JTextField jtfInvestmentAmout = new JTextField("");
	private JTextField jtfyears = new JTextField("");
	private JTextField jtfannualInterestRate = new JTextField("");
	private JTextField jtffutureValue = new JTextField("");
	
	private JButton jbtCalculate = new JButton("Calculate");
	
	public Exercise16_5(){
		draw1();
		draw2();
		add(p1,BorderLayout.CENTER);
		add(p2,BorderLayout.SOUTH);
		
		jbtCalculate.addActionListener(new ButtonListener());
	}
	
	public void draw1(){
		p1 = new JPanel(new GridLayout(4,2,10,10));
		
		p1.add(new JLabel("Investment Amout"));
		p1.add(jtfInvestmentAmout);
		p1.add(new JLabel("Years"));
		p1.add(jtfyears);
		p1.add(new JLabel("Annual Interest Rate"));
		p1.add(jtfannualInterestRate);
		p1.add(new JLabel("Future Value"));
		p1.add(jtffutureValue);
	}
	
	public void draw2(){
		p2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p2.add(jbtCalculate);
	}
	
	public class ButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			double intvestMentAmout = Double.parseDouble
					(jtfInvestmentAmout.getText());
			
			double years = Double.parseDouble
					(jtfyears.getText());
			
			double annualInterestRate = Double.parseDouble
					(jtfannualInterestRate.getText());
			
			double futureValue = intvestMentAmout *
					Math.pow((1 + annualInterestRate / 100),(years * 12));
			
			jtffutureValue.setText("" + futureValue);
		}
	}
	
	public static void main(String[] args){
		Exercise16_5 frame = new Exercise16_5();
		frame.setTitle("Exercise16_5");
		frame.setSize(400,200);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
