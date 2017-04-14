package Chapter3;

import java.util.Scanner;

public class Exercise3_1 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a,b,c:");
		double a = input.nextDouble();
		double b = input.nextDouble();
		double c = input.nextDouble();
		double x1,x2,pbs = (b * b - 4 * a * c);
		if(pbs >= 0){
			if(pbs > 0){
				x1 = ( - b + Math.sqrt(pbs)) / (2 * a);
				x2 = ( - b - Math.sqrt(pbs)) / (2 * a);
				System.out.printf("The equation has two roots %f and %f.\n",x1,x2);
			}
			else{
				x1 = x2 = - b / (2 * a);
				System.out.printf("The equation has one root %f.\n", x1);
			}
		}
		else
			System.out.println("The equation has no real roots.");
	}
}
