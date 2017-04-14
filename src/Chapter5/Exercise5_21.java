package Chapter5;

import java.util.Scanner;

public class Exercise5_21 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Loan Amount:");
		double money = input.nextDouble();
		System.out.print("Number of Years:");
		int Year = input.nextInt();
		double Rate = 5,MonthlyPayment = 0,TotalyPayment = MonthlyPayment * 12 * Year;
		System.out.println("Interest Rate    Monthly Payment    Totaly Payment");
		for(;Rate <= 8;){
			MonthlyPayment = money * Rate / 1200;
			TotalyPayment = MonthlyPayment * 12 * Year;
			System.out.printf("%.3f%%           %.2f               %.2f\n",
				Rate,MonthlyPayment,TotalyPayment);
			Rate += 0.125;
		}
	}
}
