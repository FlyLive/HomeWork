package Chapter7;

import java.util.Scanner;

public class Exercise7_10 {
	public static void main(String[] args){
		double[] numbers = new double[10];
		Scanner input = new Scanner(System.in);
		System.out.print("Enter 10 numbers:");
		for(int i = 0;i < numbers.length;i++){
			numbers[i] = input.nextDouble();
		}
		System.out.print("The smallestElement of the 10 numbers is "
			+ indexOfSmallestElement(numbers));
	}
	
	public static int indexOfSmallestElement(double[] array){
		int index = 0;
		double smallest = array[0];
		for(int i = 1;i < array.length;i++){
			if(smallest > array[i]){
				smallest = array[i];
				index = i;
			}
		}
		return index;
	}
}
