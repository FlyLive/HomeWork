package Chapter9;

public class Exercise9_8 {
	public static void main(String[] args){
		Fan f1 = new Fan();
		Fan f2 = new Fan();
		
		f1.changeSpeed(f1.FAST);
		f1.changeRadius(10);
		f1.changeColor("yellow");
		f1.changeOn(true);
		
		f2.changeSpeed(f2.MEDIUM);
		f2.changeColor("blue");
		f2.changeOn(false);
		
		System.out.println("The f1 is " + f1.tostring());
		System.out.println("The f2 is " + f2.tostring());
	}
}

class Fan{
	
	final int SLOW = 1;
	final int MEDIUM = 2;
	final int FAST = 3;
	int speed;
	boolean on;
	double radius;
	String color;
	
	Fan(){
		speed = SLOW;
		on = false;
		radius = 5;
		color = "blue";
	}
	
	int getSpeed(){					//·ÃÎÊ
		return speed;
	}
	
	boolean getOn(){
		return on;
	}
	
	double getRadius(){
		return radius;
	}
	
	String getColor(){
		return color;
	}
	
	void changeSpeed(int newSpeed){					//ÐÞ¸Ä
		speed = newSpeed;
	}
	
	void changeOn(boolean newOn){
		on = newOn;
	}
	
	void changeRadius(double newRadius){
		radius = newRadius;
	}
	
	void changeColor(String newColor){
		color = "";
		color = newColor;
	}
	
	String tostring(){
		
		String fan = "";
		fan += "speed is " + (speed - 0);
		fan += ",color is " + color;
		fan += ",radius is " + radius;
		
		if(on)
			return "On,and " + fan;
		
		return "off,and " + fan;
	}
}
