package Chapter13;

import java.util.Date;

public class Exercise13_5 {
	public static void main(String[] args){
		GeometriObject1 r1 = new Rectangle(1,2);
		GeometriObject1 r2 = new Rectangle(3,1);
		
		GeometriObject1 c1 = new Circle(1);
		GeometriObject1 c2 = new Circle(2);
		
		disPlay(r1,r2);
		disPlay(c1,c2);
	}
	public static void disPlay(GeometriObject1 g1,GeometriObject1 g2){
		GeometriObject1 m = GeometriObject1.max(g1,g2);
		if(g1 instanceof Rectangle)
			System.out.println("The max area between the rectangle "
					+ " is " + m.getArea());
		else if(g1 instanceof Circle)
			System.out.println("The max area between the coricle"
					+ " is " + m.getArea());
	}
}

class Rectangle extends GeometriObject1{
	private double width;
	private double height;
	
	public Rectangle(){
	}
	
	public Rectangle(double width, double height){
		this.width = width;
		this.height = height;
	}
	
	public Rectangle(double width,double height,
			String color,boolean filled){
		this.width = width;
		this.height = height;
		setColor(color);
		setFilled(filled);
	}
	
	public double getWidth() {
		return width;
	}
	
	public void setWidth(double width) {
		this.width = width;
	}
	
	public double getHeight() {
		return height;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public double getArea() {
		return width * height;
	}
	
	public double getPerimeter() {
		return 2 * (width + height);
	}
}

class Circle extends GeometriObject1{
	private double radius;
	
	public Circle(){
	}
	
	public Circle(double radius){
		this.radius = radius;
	}
	
	public Circle(double radius,
		String color,boolean filled){
		this.radius = radius;
		setColor(color);
		setFilled(filled);
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double getRadius(){
		return radius;
	}
	
	public double getArea(){
		return radius * radius * Math.PI;
	}
	
	public double getDiameter(){
		return 2 * radius;
	}
	
	public double getPerimeter(){
		return 2 * radius * Math.PI;
	}
	
	public void printCircle(){
		System.out.println("The circle is created " + getDateCreated()
			+ " and the radius is " + radius);
	}
}

abstract class GeometriObject1 implements Comparable<GeometricObject>{
	private String color = "white";
	private boolean filled;

	private Date datecreated;
	
	public GeometriObject1(){
		datecreated = new Date();
	}
	
	public GeometriObject1(String color,boolean filled){
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

	@Override
	public int compareTo(GeometricObject o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public abstract double getArea();
	
	public abstract double getPerimeter();
	
	public static GeometriObject1 max(GeometriObject1 object1,
			GeometriObject1 object2){
		return 
			object1.getArea() > object2.getArea() ? object1 : object2;
	}
}