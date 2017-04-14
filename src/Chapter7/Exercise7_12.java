package Chapter7;

import java.util.Scanner;

public class Exercise7_12 {
	public static void main(String[] args){
		System.out.print("Enter 10 numbers:");
		int[] n = getArray();
		System.out.println("Before change the number are:");
		display(n);
		change(n);
		System.out.println("After change the number are:");
		display(n);
	}
	
	public static void display(int[] array){
		for(int a: array)
			System.out.print(a + " ");
		System.out.println();
	}
	
	public static int[] getArray(){
		Scanner input = new Scanner(System.in);
		int[] n = new int[10];
		for(int i = 0;i < n.length;i++)
			n[i] = input.nextInt();
		return n;
	}
	
	public static void change(int[] array){
		int temp;
		for(int i = 0;i < array.length / 2;i++){
			temp = array[i];
			array[i] = array[array.length - i - 1];
			array[array.length - i - 1] = temp;
		}
	}
}
