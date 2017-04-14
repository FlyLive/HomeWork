package Chapter13;

import java.util.Date;
import java.util.Scanner;

public class Exercise13_1 {
	public static void main(String[] args){
		Triangle triangle = createdTriangle();
		System.out.println(triangle.toString());
	}
	
	public static Triangle createdTriangle(){
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a triangle with three sides:");
		double s1 = input.nextDouble();
		double s2 = input.nextDouble();
		double s3 = input.nextDouble();
		Triangle triangle = new Triangle(s1,s2,s3);
		
		System.out.println("Enter the color of this triangle:");
		input.nextLine();
		triangle.setColor(input.nextLine());
		
		System.out.println("Are this triangle is filled?");
		System.out.println("1.Yes");
		System.out.println("2.No");
		int choice = input.nextInt();
		
		if(choice == 1)
			triangle.setFilled(true);
		else if(choice == 2)
			triangle.setFilled(false);
		
		return triangle;
	}
}

class Triangle extends GeometricObject{
	private double side1;
	private double side2;
	private double side3;
	
	public Triangle(){
	}
	
	public Triangle(double side1,double side2,double side3){
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}
	
	public double getSide1() {
		return side1;
	}
	
	public double getSide2() {
		return side2;
	}
	
	public double getSide3() {
		return side3;
	}
	
	public double getArea(){
		double p = (side1 + side2 +side3) / 2;
		return	Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
		
	}
	
	public double getPerimeter(){
		return side1 + side2 + side3;
		
	}
	
	public String toString(){
		return super.toString() + "Triangle:side1 = " + side1 +
			",side2 = " + side2 + ",side3 = " + side3 + "\nThe area"
			+ " is " + this.getArea() + "\nThe perimeter is " +
			this.getPerimeter();
	}
}

abstract class GeometricObject {
	private String color = "white";
	private boolean filled;

	private Date datecreated;
	
	public GeometricObject(){
		datecreated = new Date();
	}
	
	public GeometricObject(String color,boolean filled){
		datecreated = new Date();
		this.color = color;
		this.filled = filled;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	public Date getDateCreated() {
		return datecreated;
	}
	
	@Override
	public String toString(){
		return "created on " + datecreated + "\ncolor:" + color +
			"\nFilled:" + filled + "\n";
	}
	
	public abstract double getArea();
	
	public abstract double getPerimeter();
}
