package Chapter10;

import java.util.Scanner;

public class Exercise10_4 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		double x,y;
		
		System.out.print("Enter the first point(x,y):");
		x = input.nextDouble();
		y = input.nextDouble();
		MyPoint m1 = new MyPoint(x,y);
		
		System.out.print("Enter the second point(x,y):");
		x = input.nextDouble();
		y = input.nextDouble();
		MyPoint m2 = new MyPoint(x,y);
		
		System.out.println("The distance between point1 (" + m1.getx()
			+ "," + m1.gety() + ") and point2 (" + m2.getx() + "," +
			m2.gety() + ") is " + m1.distance(m2) + " or " +
			m1.distance(x, y));
	}
}

class MyPoint{
	private double x;
	private double y;
	
	public MyPoint(){
	}
	
	public MyPoint(double x,double y){
		this.x = x;
		this.y = y;
	}
	
	public double getx(){
		return x;
	}
	
	public double gety(){
		return y;
	}
	
	public double distance(MyPoint m){
		return Math.sqrt((this.getx() - m.getx()) *
			(this.getx() - m.getx()) + (this.gety() - m.gety()) *
			(this.gety() - m.gety()));
	}
	
	public double distance(double x,double y){
		return Math.sqrt((this.getx() - x) * (this.getx() - x) +
			(this.gety() - y) * (this.gety() - y));
	}
	
	public static double distance(MyPoint m1,MyPoint m2){
		return Math.sqrt((m1.getx() - m2.getx()) *
			(m1.getx() - m2.getx()) + (m1.gety() - m2.gety()) *
			(m1.gety() - m2.gety()));
	}
	
	public static double distance(double x1,double y1,
		double x2,double y2){
		return Math.sqrt((x1 - x2) *
			(x1 - x2) + (y1 - y2) *
			(y1 - y2));
	}
}