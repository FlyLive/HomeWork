package Chapter13;

import java.util.Scanner;

public class Exercise13_17 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the first comlex number:");
		double n1 = input.nextDouble();
		double n2 = input.nextDouble();
		System.out.print("Enter the second comlex number:");
		double n3 = input.nextDouble();
		double n4 = input.nextDouble();
		
		Complex c1 = new Complex(n1,n2);
		Complex c2 = new Complex(n3,n4);
		
		
		disPlay(c1,c2);
	}
	
	public static void disPlay(Complex c1,Complex c2){
		
		System.out.println(c1.toString() + " + " + c2.toString() +
				" = " + c1.add(c2));
		System.out.println(c1.toString() + " - " + c2.toString() +
				" = " + c1.substract(c2));
		System.out.println(c1.toString() + " * " + c2.toString() +
				" = " + c1.multiply(c2));
		System.out.println(c1.toString() + " / " + c2.toString() +
				" = " + c1.divide(c2));
		System.out.println("|" + c1.toString() + "| = " + c1.abs());
		System.out.println("|" + c2.toString() + "| = " + c2.abs());
	}
}

class Complex implements Cloneable{
	private double a;
	private double b;
	private double i = Math.sqrt(-1);
	
	public Complex(){
	}
	
	public Complex(double a){
		this.a = a;
	}
	
	public Complex(double a,double b){
		this.a = a;
		this.b = b;
	}
	
	public double getRealPart(){
		return this.a;
	}
	
	public double getImaginaryPart(){
		return this.b;
	}
	
	public String add(Complex c){
		return (a + c.getRealPart()) + " + " + (b + c.getImaginaryPart())
				+ "i)";
	}
	
	public String substract(Complex c){
		return (a - c.getRealPart()) + " + " + (b - c.getImaginaryPart())
				+ "i)";
	}
	
	public String multiply(Complex c){
		return (a * c.getRealPart() - b * c.getImaginaryPart()) +
				" + " + (b * c.getRealPart() + a * c.getImaginaryPart())
				+ "i)";
	}
	
	public String divide(Complex c){
		return (a * c.getRealPart() + b * c.getImaginaryPart()) /
				(c.getRealPart() * c.getRealPart() +
				c.getImaginaryPart() * c.getImaginaryPart()) + " + " +
				(b * c.getRealPart() - a * c.getImaginaryPart()) /
				(c.getRealPart() * c.getRealPart() +
				c.getImaginaryPart() * c.getImaginaryPart())
				+ "i";
	}
	
	public double abs(){
		return Math.sqrt(this.a * this.a + this.b * this.b);
	}
	
	public Object clone() throws CloneNotSupportedException{
		return (Complex)super.clone();
	}
	
	public String toString(){
		return "(" + getRealPart() + " + " + getImaginaryPart() + "i)";
	}
}