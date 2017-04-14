package Chapter7;

import java.util.Scanner;

public class Exercise7_15 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int[] numbers = new int[10];
		System.out.print("Enter 10 numbers:");
		for(int i = 0;i < numbers.length;i++){
			numbers[i] = input.nextInt();
		}
		int[] array = eliminateDuplicates(numbers);
		System.out.print("The distinct numbers are:");
		for(int i = 0 ;i < array.length;i++){
			System.out.print(array[i] +" ");
		}
		
	}
	
	public static int[] eliminateDuplicates(int[] list){
		int n = 1;
		for(int i = 0;i < list.length;i++,n++){
			for(int j = i + 1; j < list.length;j++){
				if(list[i] == list[j])
					n--;
			}
		}
		int[] array = new int[n];
		int index = 0;
		for(int i = 0;i < array.length;i++){
			for(int j = index; j < list.length;j++){
				int p;
				for(p = 0;p < array.length;p++){
					if(array[p] == list[j])
						break;
				}
				if(p != array.length)
					continue;
				else{
						array[i] = list[j];
					break;
				}
			}
			index++;
		}
		return array;
	}
}
