package Chapter16;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Exercise16_3 extends JFrame{
	private JPanel p;
	private JButton jbtLeft = new JButton("Left");
	private JButton jbtRight = new JButton("Right");
	private JButton jbtUp = new JButton("Up");
	private JButton jbtDown = new JButton("Down");
	
	private Circle circle = new Circle();
	
	public Exercise16_3(){
		add(circle,BorderLayout.CENTER);
		draw();
		add(p,BorderLayout.SOUTH);
		
		button();
	}
	
	public void draw(){
		p = new JPanel();
		p.add(jbtLeft);
		p.add(jbtRight);
		p.add(jbtUp);
		p.add(jbtDown);
	}
	
	public void button(){
		jbtLeft.addActionListener(new ButtonListener());
		jbtRight.addActionListener(new ButtonListener());
		jbtUp.addActionListener(new ButtonListener());
		jbtDown.addActionListener(new ButtonListener());
	}
	
	class Circle extends JPanel{
		private int radius = 40;
		private int width = getWidth() / 2 - radius;
		private int height = (getHeight() / 2 - radius);
		
		public void left(){
			width-=5;
			repaint();
		}
		
		public void right(){
			width+=5;
			repaint();
		}
		
		public void up(){
			height-=5;
			repaint();
		}
		
		public void down(){
			height+=5;
			repaint();
		}
		
		protected void paintComponent(Graphics g){
			super.paintComponent(g);
			g.drawOval(width,height,2 * radius,2 * radius);
		}
	}
	
	private class ButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == jbtLeft){
				circle.left();
			}
			else if(e.getSource() == jbtRight){
				circle.right();
			}
			else if(e.getSource() == jbtUp){
				circle.up();
			}
			else if(e.getSource() == jbtDown){
				circle.down();
			}
		}
	}

	public static void main(String[] args){
		Exercise16_3 frame = new Exercise16_3();
		frame.setTitle("Exercise16_3");
		frame.setSize(400,300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
