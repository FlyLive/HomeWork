package Chapter7;

import java.util.Scanner;

public class Exercise7_8 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		double[] n = new double[10];
		System.out.print("Enter 10 numbers:");
		for(int i = 0;i < n.length;i++)
			n[i] = input.nextDouble();
		System.out.print("The 10 number's average is " + average(n));
	}
	
	public static int average(int[] array){
		int sum = 0;
		for(int i = 0;i < array.length;i++)
			sum += array[i];
		return sum / array.length;
	}
	
	public static double average(double[] array){
		double sum = 0;
		for(int i = 0;i < array.length;i++)
			sum += array[i];
		return sum / array.length;
	}
}
