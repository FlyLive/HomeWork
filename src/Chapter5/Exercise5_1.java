package Chapter5;

import java.util.Scanner;

public class Exercise5_1 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int positiveCount = 0,negativeCount = 0,Count = 0;
		double average = 0,sum = 0;
		
		System.out.print("Enter an integer, the input ends if it is 0:");
		while(true){
			int num = input.nextInt();
			sum += num;
			if(num > 0)
				positiveCount++;
			else if(num < 0)
				negativeCount++;
			else
				break;
			Count++;
		}
		average = sum / Count;
		System.out.println("The number of positive is " + positiveCount);
		System.out.println("The number of negative is " + negativeCount);
		System.out.println("The total is " + (int)(sum * 10) / 10.0);
		System.out.println("The average is " + (int)(average * 100) / 100.0);
	}
}
