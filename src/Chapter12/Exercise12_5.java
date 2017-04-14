package Chapter12;

import java.util.Date;

public class Exercise12_5 {
	public static void main(String[] args){
		
	}
	
	public static void testTriangle(Triangle t){
		
	}
}

class IllegalTriangleException extends Exception{
	private double side1;
	private double side2;
	private double side3;
	
	public IllegalTriangleException
			(double side1,double side2,double side3){
		super("The sides of " + side1 + " and " + side2 + " and"
			+ side3 + " can not come into being a triangle.");
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}

	public double getSide1() {
		return side1;
	}

	public void setSide1(double side1) {
		this.side1 = side1;
	}

	public double getSide2() {
		return side2;
	}
}

class Triangle extends SimpleGeometricObject{
	private double side1;
	private double side2;
	private double side3;
	
	public Triangle(){
	}
	
	public Triangle(double side1,double side2,double side3)
			throws IllegalTriangleException{
		if((side1 + side2) <= side3 && (side1 + side3) <= side2 
			&& (side2 + side3) <= side2){
			this.side1 = side1;
			this.side2 = side2;
			this.side3 = side3;
		}
		else
			throw new IllegalTriangleException(side1,side2,side3);
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
		return "Triangle: side1 = " + side1 + " side2 = " + side2 +
			" side3 = " + side3;
	}
}

class SimpleGeometricObject {
	private String color = "white";
	private boolean filled;
	private Date datecreated;
	
	public SimpleGeometricObject(){
		datecreated = new Date();
	}
	
	public SimpleGeometricObject(String color,boolean filled){
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

	public String toString(){
		return "created on " + datecreated + "\ncolor:" + color +
			" and filled " + filled;
	}
	
}