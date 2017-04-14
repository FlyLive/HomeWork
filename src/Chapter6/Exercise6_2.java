package Chapter6;

import java.util.Scanner;

public class Exercise6_2 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an integer(n > 0):");
		long num = input.nextLong();
		System.out.println("The sum of " + num + " is " + sumDigits(num));
	}
	public static int sumDigits(long n){
		int sumDigits = 0;
		while(n != 0){
			sumDigits += n % 10;
			n /= 10;
		}
		return sumDigits;
	}
}
