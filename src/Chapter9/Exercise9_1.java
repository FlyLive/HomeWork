package Chapter9;

public class Exercise9_1 {
	public static void main(String[] args){
		
	Rectangle rectangle1 = new Rectangle(4,40);
	
	System.out.println("The area of rectangle of width "
		+ rectangle1.width + " and ehight " + rectangle1.height
		+ " is " + rectangle1.getArea() + " and  the perimeter "
		+ " is " + rectangle1.getPerimeter());
	
	Rectangle rectangle2 = new Rectangle(3.5,35.9);
	
	System.out.println("The area of rectangle of width "
		+ rectangle2.width + " and ehight " + rectangle2.height
		+ " is " + rectangle2.getArea() + " and  the perimeter "
		+ " is " + rectangle2.getPerimeter());
	}
}
class Rectangle{
	double width;
	double height;
	
	Rectangle(){
		width = 1;
		height = 1;
	}
	
	Rectangle(double newWidth,double newHeight){
		width = newWidth;
		height = newHeight;
	}
	
	double getArea(){
		return width * height;
	}
	
	double getPerimeter(){
		return 2 * (width + height);
	}
}
